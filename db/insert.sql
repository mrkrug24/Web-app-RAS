-- ВУЗы
INSERT INTO university VALUES
(1, 'Московский государственный университет имени М.В. Ломоносова'),
(2, 'Московский физико-технический институт'),
(3, 'Национальный исследовательский университет «Высшая школа экономики»');

-- Специальности
INSERT INTO speciality VALUES
(1, 'Дизайн'),
(2, 'Информационная безопасность'),
(3, 'Менеджмент'),
(4, 'Прикладная математика и информатика'),
(5, 'Программная инженерия'),
(6, 'Реклама и связи с общественностью'),
(7, 'Экономика');

-- Компании
INSERT INTO company VALUES
(1, 'VK'),
(2, 'Ozon'),
(3, 'Тинькофф'),
(4, 'Яндекс');

-- Должности
INSERT INTO position VALUES
(1, 'Аналитик данных'), --2
(2, 'Архитектор информационных систем'), --2
(3, 'Дизайнер пользовательских интерфейсов'),
(4, 'Специалист по информационной безопасности и защите данных'), --2
(5, 'Разработчик мобильных приложений'),
(6, 'Менеджер по развитию рекламных технологий'),
(7, 'Специалист по машинному обучению');

-- Соискатели
INSERT INTO applicant VALUES
(1, 'Анна', 'Сергеевна', 'Иванова', 'Ленинский проспект', 10, 25, 1, 120000),
(2, 'Дмитрий', 'Андреевич', 'Петров', 'Профсоюзная улица', 5, 15, 1, 150000),
(3, 'Елена', 'Александровна', 'Смирнова', 'Кутузовский проспект', 20, 12, 2, 180000),
(4, 'Иван', 'Дмитриевич', 'Козлов', 'Проспект Вернадского', 30, 7, 2, 200000),
(5, 'Мария', 'Ивановна', 'Федорова', 'Тверская улица', 40, 3, 3, 100000),
(6, 'Алексей', 'Павлович', 'Соколов', 'Пресненская набережная', 15, 9, 4, 160000),
(7, 'Ольга', 'Михайловна', 'Новикова', 'Новый Арбат', 1, 18, 4, 140000),
(8, 'Артем', 'Алексеевич', 'Морозов', 'Каширское шоссе', 50, 22, 5, 120000),
(9, 'Светлана', 'Игоревна', 'Васильева', 'Варшавское шоссе', 12, 5, 6, 100000),
(10, 'Андрей', 'Владимирович', 'Ковалев', 'Ленинградский проспект', 18, 30, 7, 250000);

-- Образования
INSERT INTO education VALUES
(1, 1, 4),
(2, 2, 4),
(2, 3, 7),
(3, 3, 5),
(4, 3, 5),
(4, 2, 4),
(5, 1, 5),
(5, 3, 1),
(6, 1, 2),
(6, 3, 2),
(7, 3, 2),
(8, 1, 5),
(8, 3, 5),
(9, 3, 3),
(9, 3, 6),
(10, 1, 4),
(10, 2, 4);

-- История работы
INSERT INTO workhistory VALUES
(1, 4, 7, 80000, '2020-02-03', '2021-04-05'),
(1, 2, 1, 110000, '2021-04-05', NULL),
(2, 1, 7, 100000, '2015-06-07', '2019-08-09'),
(2, 4, 7, 120000, '2019-08-09', '2023-10-11'),
(2, 3, 1, 140000, '2023-10-11', NULL),
(3, 1, 2, 150000, '2021-09-10', NULL),
(4, 3, 5, 100000, '2020-03-04', '2022-05-06'),
(4, 1, 2, 180000, '2022-05-06', NULL),
(5, 2, 3, 90000, '2023-07-08', NULL),
(6, 1, 4, 90000, '2021-07-08', '2022-02-05'),
(6, 3, 4, 140000, '2022-02-05', NULL),
(7, 4, 4, 130000, '2023-09-21', NULL),
(8, 4, 5, 110000, '2022-03-17', NULL),
(9, 1, 6, 80000, '2023-04-29', NULL),
(10, 2, 1, 120000, '2020-02-01', '2022-10-14'),
(10, 4, 7, 200000, '2022-10-14', NULL);

-- Вакансии
INSERT INTO vacancy VALUES
(1, 1, 150000, 4, NULL),
(1, 3, 120000, 1, 1),
(1, 4, 160000, 2, 1),
(1, 5, 120000, 5, NULL),
(1, 7, 250000, 4, 1),
(2, 1, 160000, 4, 1),
(2, 2, 200000, 5, NULL),
(2, 3, 130000, 1, 1),
(2, 4, 170000, 2, 1),
(2, 5, 130000, 5, NULL),
(2, 6, 110000, 3, 1),
(2, 7, 300000, 4, NULL),
(3, 1, 140000, 4, 2),
(3, 3, 110000, 1, 2),
(3, 4, 150000, 2, 2),
(4, 1, 150000, 4, NULL),
(4, 2, 180000, 5, 1),
(4, 3, 120000, 1, 1),
(4, 6, 100000, 3, NULL),
(4, 7, 250000, 4, 1);