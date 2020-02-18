INSERT INTO "user"(id, name, email, login, password) values(NEXTVAL('user_id_seq'), 'Андрей', 'andrey@test.ts', 'A1n', 'user');
INSERT INTO "user"(id, name, email, login, password) values(NEXTVAL('user_id_seq'), 'Дима', 'dima@test.ts', 'Dimmer', 'user');
INSERT INTO "user"(id, name, email, login, password) values(NEXTVAL('user_id_seq'), 'Максим', 'maxim@test.ts', 'Maximer', 'user');
INSERT INTO "user"(id, name, email, login, password) values(NEXTVAL('user_id_seq'), 'Лена', 'lena@test.ts', 'Vova', 'user');
INSERT INTO "user"(id, name, email, login, password) values(NEXTVAL('user_id_seq'), 'Аня', 'anna@test.ts', 'Anna', 'user');
INSERT INTO "user"(id, name, email, login, password) values(NEXTVAL('user_id_seq'), 'Коля', 'kola@test.ts', 'Kola', 'user');
INSERT INTO "user"(id, name, email, login, password) values(NEXTVAL('user_id_seq'), 'Test', 'test@test.ts', 'user', 'user');       

INSERT INTO allowance(id, country, value) values(NEXTVAL('allowance_id_seq'), 'Россия', 6);
INSERT INTO allowance(id, country, value) values(NEXTVAL('allowance_id_seq'), 'Германия', 12);
INSERT INTO allowance(id, country, value) values(NEXTVAL('allowance_id_seq'), 'Польша', 9);
INSERT INTO allowance(id, country, value) values(NEXTVAL('allowance_id_seq'), 'Швеция', 21);
INSERT INTO allowance(id, country, value) values(NEXTVAL('allowance_id_seq'), 'Китай', 16);
INSERT INTO allowance(id, country, value) values(NEXTVAL('allowance_id_seq'), 'Оман', 13);
INSERT INTO allowance(id, country, value) values(NEXTVAL('allowance_id_seq'), 'Беларусь', 6);
INSERT INTO allowance(id, country, value) values(NEXTVAL('allowance_id_seq'), 'Тайвань', 14);

INSERT INTO ticket(id, "from", "to", date, price, type) values(NEXTVAL('ticket_id_seq'), 'Беларусь', 'Германия', '2020-01-16 10:10:10-10', 450, 'TRAIN');
INSERT INTO ticket(id, "from", "to", date, price, type) values(NEXTVAL('ticket_id_seq'), 'Германия', 'Беларусь', '2020-01-22 10:10:10-10', 380, 'TRAIN');
INSERT INTO ticket(id, "from", "to", date, price, type) values(NEXTVAL('ticket_id_seq'), 'Беларусь', 'Польша', '2020-01-11 10:10:10-10', 70, 'BUS');
INSERT INTO ticket(id, "from", "to", date, price, type) values(NEXTVAL('ticket_id_seq'), 'Польша', 'Беларусь', '2020-01-23 10:10:10-10', 65, 'BUS');
INSERT INTO ticket(id, "from", "to", date, price, type) values(NEXTVAL('ticket_id_seq'), 'Беларусь', 'Швеция', '2020-02-12 10:10:10-10', 330, 'PALNE');
INSERT INTO ticket(id, "from", "to", date, price, type) values(NEXTVAL('ticket_id_seq'), 'Швеция', 'Беларусь', '2020-02-23 10:10:10-10', 290, 'PALNE');
INSERT INTO ticket(id, "from", "to", date, price, type) values(NEXTVAL('ticket_id_seq'), 'Беларусь', 'Китай', '2020-02-22 10:10:10-10', 1150, 'PALNE');
INSERT INTO ticket(id, "from", "to", date, price, type) values(NEXTVAL('ticket_id_seq'), 'Китай', 'Тайвань', '2020-02-24 10:10:10-10', 340, 'PALNE');
INSERT INTO ticket(id, "from", "to", date, price, type) values(NEXTVAL('ticket_id_seq'), 'Тайвань', 'Беларусь', '2020-02-26 10:10:10-10', 850, 'PALNE');

INSERT INTO employee(id, name, surname, department, birthday, email, is_relevant) values(NEXTVAL('employee_id_seq'), 'Олег', 'Тестов', 'Отдел продаж', '1979-03-06', 'olg@test.ts', 'true');
INSERT INTO employee(id, name, surname, department, birthday, email, is_relevant) values(NEXTVAL('employee_id_seq'), 'Александр', 'Тестов', 'Отдел кадров', '1989-03-06', 'sasha@test.ts', 'true');
INSERT INTO employee(id, name, surname, department, birthday, email, is_relevant) values(NEXTVAL('employee_id_seq'), 'Сергей', 'Тестов', 'Отдел производства', '1991-03-06', 'sergey@test.ts', 'true');
INSERT INTO employee(id, name, surname, department, birthday, email, is_relevant) values(NEXTVAL('employee_id_seq'), 'Владимир', 'Тестов', 'Отдел разработки', '1996-03-06', 'voloda@test.ts', 'true');
INSERT INTO employee(id, name, surname, department, birthday, email, is_relevant) values(NEXTVAL('employee_id_seq'), 'Елена', 'Тестова', 'Отдел кадров', '1973-03-06', 'lena@test.ts', 'true');
INSERT INTO employee(id, name, surname, department, birthday, email, is_relevant) values(NEXTVAL('employee_id_seq'), 'Татьяна', 'Тестова', 'Отдел продаж', '1983-03-06', 'tanya@test.ts', 'true');

INSERT INTO trip(id, title, description, employee_id, date_start, date_end, status) values(NEXTVAL('trip_id_seq'), 'Повышение квалификации', 'Текст...', 5, '2020-01-16 10:10:10-10', '2020-01-22 10:10:10-10', 'COMPLETED');
INSERT INTO trip(id, title, description, employee_id, date_start, date_end, status) values(NEXTVAL('trip_id_seq'), 'Заключение договора', 'Текст...', 4, '2020-01-11 10:10:10-10', '2020-01-23 10:10:10-10', 'COMPLETED');
INSERT INTO trip(id, title, description, employee_id, date_start, date_end, status) values(NEXTVAL('trip_id_seq'), 'Проверка производства', 'Текст...', 6, '2020-02-12 10:10:10-10', '2020-02-23 10:10:10-10', 'IN_POGRESS');
INSERT INTO trip(id, title, description, employee_id, date_start, date_end, status) values(NEXTVAL('trip_id_seq'), 'Сертификат качества', 'Текст...', 2, '2020-02-22 10:10:10-10', '2020-02-26 10:10:10-10', 'FUTURE');

INSERT INTO trip_allowance(trip_id, allowance_id, days) values(1, 2, 7);
INSERT INTO trip_allowance(trip_id, allowance_id, days) values(2, 3, 13);
INSERT INTO trip_allowance(trip_id, allowance_id, days) values(3, 4, 12);
INSERT INTO trip_allowance(trip_id, allowance_id, days) values(4, 5, 3);
INSERT INTO trip_allowance(trip_id, allowance_id, days) values(4, 8, 2);

INSERT INTO trip_ticket(trip_id, ticket_id) values(1, 1);
INSERT INTO trip_ticket(trip_id, ticket_id) values(1, 2);
INSERT INTO trip_ticket(trip_id, ticket_id) values(2, 3);
INSERT INTO trip_ticket(trip_id, ticket_id) values(2, 4);
INSERT INTO trip_ticket(trip_id, ticket_id) values(3, 5);
INSERT INTO trip_ticket(trip_id, ticket_id) values(3, 6);
INSERT INTO trip_ticket(trip_id, ticket_id) values(4, 7);
INSERT INTO trip_ticket(trip_id, ticket_id) values(4, 8);
INSERT INTO trip_ticket(trip_id, ticket_id) values(4, 9);

