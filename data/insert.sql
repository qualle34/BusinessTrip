INSERT INTO allowance(id, country, value, currency) values(NEXTVAL('allowance_id_seq'), 'Россия', 6, 'USD ($)');
INSERT INTO allowance(id, country, value, currency) values(NEXTVAL('allowance_id_seq'), 'Германия', 12, 'USD ($)');
INSERT INTO allowance(id, country, value, currency) values(NEXTVAL('allowance_id_seq'), 'Польша', 9, 'USD ($)');
INSERT INTO allowance(id, country, value, currency) values(NEXTVAL('allowance_id_seq'), 'Швеция', 21, 'USD ($)');
INSERT INTO allowance(id, country, value, currency) values(NEXTVAL('allowance_id_seq'), 'Китай', 16, 'USD ($)');
INSERT INTO allowance(id, country, value, currency) values(NEXTVAL('allowance_id_seq'), 'Оман', 13, 'USD ($)');
INSERT INTO allowance(id, country, value, currency) values(NEXTVAL('allowance_id_seq'), 'Беларусь', 6, 'USD ($)');
INSERT INTO allowance(id, country, value, currency) values(NEXTVAL('allowance_id_seq'), 'Тайвань', 14, 'USD ($)');

INSERT INTO employee(id, name, surname, department, birthday, email) values(NEXTVAL('employee_id_seq'), 'Олег', 'Тестов', 'Отдел продаж', '1979-03-06', 'olg@test.ts');
INSERT INTO employee(id, name, surname, department, birthday, email) values(NEXTVAL('employee_id_seq'), 'Александр', 'Тестов', 'Отдел кадров', '1989-03-06', 'sasha@test.ts');
INSERT INTO employee(id, name, surname, department, birthday, email) values(NEXTVAL('employee_id_seq'), 'Сергей', 'Тестов', 'Отдел производства', '1991-03-06', 'sergey@test.ts');
INSERT INTO employee(id, name, surname, department, birthday, email) values(NEXTVAL('employee_id_seq'), 'Владимир', 'Тестов', 'Отдел разработки', '1996-03-06', 'voloda@test.ts');
INSERT INTO employee(id, name, surname, department, birthday, email) values(NEXTVAL('employee_id_seq'), 'Елена', 'Тестова', 'Отдел кадров', '1973-03-06', 'lena@test.ts');
INSERT INTO employee(id, name, surname, department, birthday, email) values(NEXTVAL('employee_id_seq'), 'Татьяна', 'Тестова', 'Отдел продаж', '1983-03-06', 'tanya@test.ts');

INSERT INTO trip(id, title, description, place, date_start, date_end, additional_expenses) values(NEXTVAL('trip_id_seq'), 'Повышение квалификации', 'Текст...', 'Германия', '2020-01-16 10:10:10-10', '2020-01-22 10:10:10-10', 40);
INSERT INTO trip(id, title, description, place, date_start, date_end, additional_expenses) values(NEXTVAL('trip_id_seq'), 'Заключение договора', 'Текст...', 'Офис Black Red White', '2020-01-11 10:10:10-10', '2020-01-23 10:10:10-10', 0);
INSERT INTO trip(id, title, description, place, date_start, date_end, additional_expenses) values(NEXTVAL('trip_id_seq'), 'Проверка производства', 'Текст...', 'Швеция', '2020-02-12 10:10:10-10', '2020-02-23 10:10:10-10', 10);
INSERT INTO trip(id, title, description, place, date_start, date_end, additional_expenses) values(NEXTVAL('trip_id_seq'), 'Сертификат качества', 'Текст...', 'Китай', '2020-02-22 10:10:10-10', '2020-02-26 10:10:10-10', 23);

INSERT INTO member(id, employee_id, trip_id, role) values(NEXTVAL('member_id_seq'), 5, 1, 'роль');
INSERT INTO member(id, employee_id, trip_id, role) values(NEXTVAL('member_id_seq'), 2, 2, 'роль');
INSERT INTO member(id, employee_id, trip_id, role) values(NEXTVAL('member_id_seq'), 1, 3, 'роль');
INSERT INTO member(id, employee_id, trip_id, role) values(NEXTVAL('member_id_seq'), 3, 4, 'роль');
INSERT INTO member(id, employee_id, trip_id, role) values(NEXTVAL('member_id_seq'), 4, 4, 'роль');

INSERT INTO member_allowance(member_id, allowance_id, days) values(1, 2, 7);
INSERT INTO member_allowance(member_id, allowance_id, days) values(2, 3, 13);
INSERT INTO member_allowance(member_id, allowance_id, days) values(3, 4, 12);
INSERT INTO member_allowance(member_id, allowance_id, days) values(4, 5, 3);
INSERT INTO member_allowance(member_id, allowance_id, days) values(4, 8, 2);
INSERT INTO member_allowance(member_id, allowance_id, days) values(5, 5, 3);
INSERT INTO member_allowance(member_id, allowance_id, days) values(5, 8, 2);

INSERT INTO ticket(id, member_id, "from", "to", date, price, type) values(NEXTVAL('ticket_id_seq'), 1, 'Беларусь', 'Германия', '2020-01-16 10:10:10-10', 450, 'TRAIN');
INSERT INTO ticket(id, member_id, "from", "to", date, price, type) values(NEXTVAL('ticket_id_seq'), 1, 'Германия', 'Беларусь', '2020-01-22 10:10:10-10', 380, 'TRAIN');
INSERT INTO ticket(id, member_id, "from", "to", date, price, type) values(NEXTVAL('ticket_id_seq'), 2, 'Беларусь', 'Польша', '2020-01-11 10:10:10-10', 70, 'BUS');
INSERT INTO ticket(id, member_id, "from", "to", date, price, type) values(NEXTVAL('ticket_id_seq'), 2, 'Польша', 'Беларусь', '2020-01-23 10:10:10-10', 65, 'BUS');
INSERT INTO ticket(id, member_id, "from", "to", date, price, type) values(NEXTVAL('ticket_id_seq'), 3, 'Беларусь', 'Швеция', '2020-02-12 10:10:10-10', 330, 'PLANE');
INSERT INTO ticket(id, member_id, "from", "to", date, price, type) values(NEXTVAL('ticket_id_seq'), 3, 'Швеция', 'Беларусь', '2020-02-23 10:10:10-10', 290, 'PLANE');
INSERT INTO ticket(id, member_id, "from", "to", date, price, type) values(NEXTVAL('ticket_id_seq'), 4, 'Беларусь', 'Китай', '2020-02-22 10:10:10-10', 1150, 'PLANE');
INSERT INTO ticket(id, member_id, "from", "to", date, price, type) values(NEXTVAL('ticket_id_seq'), 4, 'Китай', 'Тайвань', '2020-02-24 10:10:10-10', 340, 'PLANE');
INSERT INTO ticket(id, member_id, "from", "to", date, price, type) values(NEXTVAL('ticket_id_seq'), 4, 'Тайвань', 'Беларусь', '2020-02-26 10:10:10-10', 850, 'PLANE');
INSERT INTO ticket(id, member_id, "from", "to", date, price, type) values(NEXTVAL('ticket_id_seq'), 5, 'Беларусь', 'Китай', '2020-02-22 10:10:10-10', 1150, 'PLANE');
INSERT INTO ticket(id, member_id, "from", "to", date, price, type) values(NEXTVAL('ticket_id_seq'), 5, 'Китай', 'Тайвань', '2020-02-24 10:10:10-10', 340, 'PLANE');
INSERT INTO ticket(id, member_id, "from", "to", date, price, type) values(NEXTVAL('ticket_id_seq'), 5, 'Тайвань', 'Беларусь', '2020-02-26 10:10:10-10', 850, 'PLANE');
