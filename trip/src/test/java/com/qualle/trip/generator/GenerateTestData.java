package com.qualle.trip.generator;

import com.github.javafaker.Faker;
import com.qualle.trip.model.enums.TicketType;
import org.junit.jupiter.api.*;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GenerateTestData {

    private static final int START_COUNT = 1;
    private static final int ALLOWANCE_COUNT = 100;
    private static final int EMPLOYEE_COUNT = 200;
    private static final int MAX_ALLOWANCE_DAYS = 40;

    private static final int TRIP_COUNT = EMPLOYEE_COUNT / 2;
    private static final int MEMBER_COUNT = (int) (TRIP_COUNT * 1.5);
    private static final int TICKET_COUNT = MEMBER_COUNT * 2;

    private static final int MAX_ALLOWANCE_BYN = 100;
    private static final int MAX_EXPENSES_BYN = 300;
    private static final int MAX_TICKET_BYN = 700;

    private static final Date DATE_FROM = Date.from(Instant.now().minusSeconds(60 * 60 * 60 * 24 * 30));
    private static final Date DATE_NOW = Date.from(Instant.now());
    private static final Date DATE_TO = Date.from(Instant.now().plusSeconds(60 * 60 * 60 * 24 * 30));

    private static final String ALLOWANCE_TEMPLATE = "INSERT INTO allowance(id, country, value) values(NEXTVAL(''allowance_id_seq''), ''{0}'', {1});";
    private static final String EMPLOYEE_TEMPLATE = "INSERT INTO employee(id, name, surname, patronymic, position, department, birthday, email) values(NEXTVAL(''employee_id_seq''), ''{0}'', ''{1}'', ''{2}'', ''{3}'', ''{4}'', ''{5}'', ''{6}'');";
    private static final String TRIP_TEMPLATE = "INSERT INTO trip(id, title, description, place, date_start, date_end, additional_expenses) values(NEXTVAL(''trip_id_seq''), ''{0}'', ''{1}'', ''{2}'', ''{3}'', ''{4}'', {5});";
    private static final String MEMBER_TEMPLATE = "INSERT INTO member(id, employee_id, trip_id, role) values(NEXTVAL(''member_id_seq''), {0}, {1}, ''{2}'');";
    private static final String MEMBER_ALLOWANCE_TEMPLATE = "INSERT INTO member_allowance(member_id, allowance_id, days) values({0}, {1}, {2});";
    private static final String TICKET_TEMPLATE = "INSERT INTO ticket(id, member_id, \"from\", \"to\", date, price, type) values(NEXTVAL(''ticket_id_seq''), {0}, ''{1}'', ''{2}'', ''{3}'', {4}, ''{5}'');";

    private Faker faker;
    private Faker fakerRu;

    @BeforeEach
    void init() {
        faker = new Faker(Locale.ENGLISH);
        fakerRu = new Faker(new Locale("ru"));
    }

    @Test
    @Order(1)
    void generateAllowance() throws Exception {
        Set<String> uniqueValues = new HashSet<>();
        Set<String> uniqueCountries = new HashSet<>();

        for (int i = 0; i < ALLOWANCE_COUNT; i++) {
            String country = fixCountry(fakerRu.address().country());
            if (!uniqueCountries.contains(country)) {
                uniqueValues.add(MessageFormat.format(ALLOWANCE_TEMPLATE,
                        country,
                        fakerRu.random().nextInt(MAX_ALLOWANCE_BYN)));
                uniqueCountries.add(country);
            }
        }

        printCollection(uniqueValues);
    }

    @Test
    @Order(2)
    void generateEmployee() throws Exception {
        Set<String> uniqueValues = new HashSet<>();

        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            String fullName = fakerRu.name().nameWithMiddle();
            uniqueValues.add(MessageFormat.format(EMPLOYEE_TEMPLATE,
                    getMiddleName(fullName, 0),
                    getMiddleName(fullName, 1),
                    getMiddleName(fullName, 2),
                    fakerRu.name().title(),
                    fakerRu.job().field(),
                    getSimpleDate(faker.date().birthday()),
                    faker.internet().emailAddress()));
        }

        printCollection(uniqueValues);
    }

    @Test
    @Order(3)
    void generateTrip() throws Exception {
        Set<String> uniqueValues = new HashSet<>();

        for (int i = 0; i < TRIP_COUNT; i++) {
            uniqueValues.add(MessageFormat.format(TRIP_TEMPLATE,
                    fakerRu.job().field(),
                    "Test text: " + fakerRu.ancient().hero(),
                    fixCountry(fakerRu.address().city()),
                    getSimpleDateTime(faker.date().between(DATE_FROM, DATE_NOW)),
                    getSimpleDateTime(faker.date().between(DATE_NOW, DATE_TO)),
                    faker.random().nextInt(MAX_EXPENSES_BYN)));
        }

        printCollection(uniqueValues);
    }

    @Test
    @Order(4)
    void generateMember() throws Exception {
        Set<String> uniqueValues = new HashSet<>();

        for (int i = 0; i < MEMBER_COUNT; i++) {
            uniqueValues.add(MessageFormat.format(MEMBER_TEMPLATE,
                    faker.random().nextInt(START_COUNT, EMPLOYEE_COUNT),
                    faker.random().nextInt(START_COUNT, TRIP_COUNT),
                    fakerRu.job().title()));
        }

        printCollection(uniqueValues);
    }

    @Test
    @Order(5)
    void generateMemberAllowance() throws Exception {
        Set<String> uniqueValues = new HashSet<>();
        Set<String> uniqueIds = new HashSet<>();

        for (int i = 0; i < MEMBER_COUNT; i++) {
            int memberId = faker.random().nextInt(START_COUNT, MEMBER_COUNT);
            int allowanceId = faker.random().nextInt(START_COUNT, ALLOWANCE_COUNT / 2);

            if (!uniqueIds.contains(memberId + "-" + allowanceId)) {
                uniqueValues.add(MessageFormat.format(MEMBER_ALLOWANCE_TEMPLATE,
                        memberId,
                        allowanceId,
                        faker.random().nextInt(START_COUNT, MAX_ALLOWANCE_DAYS)));
                uniqueIds.add(memberId + "-" + allowanceId);
            }
        }

        printCollection(uniqueValues);
    }

    @Test
    @Order(6)
    void generateTicket() throws Exception {
        Set<String> uniqueValues = new HashSet<>();

        for (int i = 0; i < TICKET_COUNT; i++) {
            uniqueValues.add(MessageFormat.format(TICKET_TEMPLATE,
                    faker.random().nextInt(START_COUNT, MEMBER_COUNT),
                    fixCountry(fakerRu.address().country() + ", " + fakerRu.address().city()),
                    fixCountry(fakerRu.address().country() + ", " + fakerRu.address().city()),
                    getSimpleDateTime(faker.date().between(DATE_FROM, DATE_TO)),
                    faker.random().nextInt(MAX_TICKET_BYN),
                    randomTicketType(TicketType.class).name()));
        }

        printCollection(uniqueValues);
    }

    private String fixCountry(String country) {
        return country.replace("'", " ");
    }

    private void printCollection(Collection<String> data) {
        data.forEach(System.out::println);
    }

    private String getSimpleDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }

    private String getSimpleDateTime(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date) + "-00";
    }

    private String getMiddleName(String fullName, int path) {
        return fullName.split(" ")[path];
    }

    public <T extends Enum<?>> T randomTicketType(Class<T> clazz) {
        int x = faker.random().nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }
}
