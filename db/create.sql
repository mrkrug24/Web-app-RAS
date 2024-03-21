-- Создание таблицы ВУЗов
CREATE TABLE university (
    id SERIAL PRIMARY KEY,  -- Первичный ключ
    name TEXT NOT NULL,     -- Название
    UNIQUE (name)           -- Уникальность названия
);

-- Создание таблицы специальностей
CREATE TABLE speciality (
    id SERIAL PRIMARY KEY,  -- Первичный ключ
    name TEXT NOT NULL,     -- Название
    UNIQUE (name)           -- Уникальность названия
);

-- Создание таблицы компаний
CREATE TABLE company (
    id SERIAL PRIMARY KEY,  -- Первичный ключ
    name TEXT NOT NULL,     -- Название
    UNIQUE (name)           -- Уникальность названия
);

-- Создание таблицы должностей
CREATE TABLE position (
    id SERIAL PRIMARY KEY,  -- Первичный ключ
    name TEXT NOT NULL,     -- Название
    UNIQUE (name)           -- Уникальность названия
);

-- Создание таблицы соискателей
CREATE TABLE applicant (
    id SERIAL PRIMARY KEY,      -- Первичный ключ
    first_name TEXT NOT NULL,   -- Имя
    middle_name TEXT,           -- Отчество
    last_name TEXT NOT NULL,    -- Фамилия
    street TEXT NOT NULL,       -- Улица
    building INT NOT NULL,      -- Дом
    apartment INT NOT NULL,     -- Квартира
    sought_post INT,            -- Искомая должность
    sought_salary INT,          -- Желаемая зарплата
    FOREIGN KEY (sought_post) REFERENCES position(id) ON DELETE CASCADE     -- Внешний ключ
);

-- Создание таблицы образования
CREATE TABLE education (
    applicant_id INT NOT NULL,  -- Соискатель
    university_id INT NOT NULL, -- ВУЗ
    speciality_id INT NOT NULL, -- Специальность
    PRIMARY KEY (applicant_id, university_id, speciality_id),                   -- Первичный ключ
    FOREIGN KEY (applicant_id) REFERENCES applicant(id) ON DELETE CASCADE,      -- Внешний ключ
    FOREIGN KEY (university_id) REFERENCES university(id) ON DELETE CASCADE,    -- Внешний ключ
    FOREIGN KEY (speciality_id) REFERENCES speciality(id) ON DELETE CASCADE     -- Внешний ключ
);

-- Создание таблицы истории работы
CREATE TABLE workhistory (
    applicant_id INT NOT NULL,      -- Соискатель
    company_id INT NOT NULL,        -- Компания
    position_id INT NOT NULL,       -- Должность
    salary INT NOT NULL,            -- Зарплата
    start_date DATE NOT NULL,       -- Начало периода
    end_date DATE,                  -- Конец периода
    CHECK (start_date < end_date),  -- Проверка дат
    PRIMARY KEY (applicant_id, company_id, position_id),                        -- Первичный ключ
    FOREIGN KEY (applicant_id) REFERENCES applicant(id) ON DELETE CASCADE,      -- Внешний ключ
    FOREIGN KEY (company_id) REFERENCES company(id) ON DELETE CASCADE,          -- Внешний ключ
    FOREIGN KEY (position_id) REFERENCES position(id) ON DELETE CASCADE         -- Внешний ключ
);

-- Создание таблицы вакансий
CREATE TABLE vacancy (
    company_id INT NOT NULL,    -- Компания
    position_id INT NOT NULL,   -- Должность
    salary INT NOT NULL,        -- Зарплата
    req_spec INT,               -- Требуемая специальность
    req_exp INT,                -- Требуемый стаж работы
    PRIMARY KEY (company_id, position_id),                                  -- Первичный ключ
    FOREIGN KEY (company_id) REFERENCES company(id) ON DELETE CASCADE,      -- Внешний ключ
    FOREIGN KEY (position_id) REFERENCES position(id) ON DELETE CASCADE,    -- Внешний ключ
    FOREIGN KEY (req_spec) REFERENCES speciality(id) ON DELETE CASCADE      -- Внешний ключ
);