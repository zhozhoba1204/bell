CREATE TABLE IF NOT EXISTS Organization (
    id         INTEGER              COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    version    INTEGER NOT NULL     COMMENT 'Служебное поле hibernate',
    name       VARCHAR(50) NOT NULL COMMENT 'Название организации',
    full_name  VARCHAR(50) NOT NULL COMMENT 'Полное название',
    inn        VARCHAR(50) NOT NULL COMMENT 'ИНН',
    kpp        VARCHAR(50) NOT NULL COMMENT 'КПП',
    address    VARCHAR(50) NOT NULL COMMENT 'Адрес',
    phone      VARCHAR(10) NOT NULL COMMENT 'Номер телефона'
);
COMMENT ON TABLE Organization IS 'Организация';


CREATE TABLE IF NOT EXISTS Office (
    id         INTEGER              COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    version    INTEGER     NOT NULL COMMENT 'Служебное поле hibernate',
    name       VARCHAR(50) NOT NULL COMMENT 'Название офиса',
    org_id     INTEGER     NOT NULL COMMENT 'Номер организации',
    address    VARCHAR(50) NOT NULL COMMENT 'Адрес',
    phone      VARCHAR(10) NOT NULL COMMENT 'Номер телефона'
);
COMMENT ON TABLE Office IS 'Офис';

CREATE TABLE IF NOT EXISTS Usr (
    id         INTEGER              COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    version    INTEGER     NOT NULL COMMENT 'Служебное поле hibernate',
    first_name VARCHAR(50) NOT NULL COMMENT 'Имя',
    middle_name VARCHAR(50) NOT NULL COMMENT 'Отчество',
    last_name  VARCHAR(50) NOT NULL COMMENT 'Фамилия',
    position   VARCHAR(50) NOT NULL COMMENT 'Должность',
    phone      VARCHAR(10) NOT NULL COMMENT 'Номер телефона',
    office_id  INTEGER     NOT NULL COMMENT 'Уникальный идентификатор офиса',
    citizenship_id INTEGER NOT NULL COMMENT 'Уникальный идентификатор гражданства',
    doc_number VARCHAR(50) NOT NULL COMMENT 'Номер документа'
);
COMMENT ON TABLE Usr IS 'Пользователь';

CREATE TABLE IF NOT EXISTS Document_info (
    doc_number VARCHAR(50) NOT NULL     COMMENT 'Номер документа' PRIMARY KEY,
    version    INTEGER     NOT NULL     COMMENT 'Служебное поле hibernate',
    doc_date   VARCHAR(50) NOT NULL     COMMENT 'Дата выдачи',
    doc_name   VARCHAR(50) NOT NULL     COMMENT 'Наименование документа'
);
COMMENT ON TABLE Document_info IS 'Данные документа';

CREATE TABLE IF NOT EXISTS Document_type (
    doc_name   VARCHAR(50)  NOT NULL     COMMENT 'Наименование документа' PRIMARY KEY,
    version    INTEGER      NOT NULL     COMMENT 'Служебное поле hibernate',
    doc_code   VARCHAR(2)   NOT NULL     COMMENT 'Код документа'
);
COMMENT ON TABLE Document_type IS 'Тип документа';

CREATE TABLE IF NOT EXISTS Citizenship (
    id                 INTEGER                    COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    version            INTEGER       NOT NULL     COMMENT 'Служебное поле hibernate',
    citizenship_code   VARCHAR(5)    NOT NULL     COMMENT 'Код страны',
    citizenship_name   VARCHAR(50)   NOT NULL     COMMENT 'Гражданство'
);
COMMENT ON TABLE Citizenship IS 'Гражданство';

-- CREATE INDEX IX_Person_House_Id ON Person_House (house_id); ???
ALTER TABLE Office ADD FOREIGN KEY (org_id) REFERENCES Organization(id);

ALTER TABLE Usr ADD FOREIGN KEY (office_id) REFERENCES Office(id);

ALTER TABLE Usr ADD FOREIGN KEY (citizenship_id) REFERENCES Citizenship(citizenship_code);

ALTER TABLE Usr ADD FOREIGN KEY (doc_number) REFERENCES Document_info(doc_number);

ALTER TABLE Document_info ADD FOREIGN KEY (doc_name) REFERENCES Document_type(doc_name);

