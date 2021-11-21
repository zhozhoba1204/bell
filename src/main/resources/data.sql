INSERT INTO Organization (
        id, version, name, full_name, inn, kpp, address, phone)
        VALUES (1, 0, 'Polo', 'US POLO', '111', '222', 'Msk', '84950000001');

INSERT INTO Office (
        id, version, name, org_id, address, phone)
        VALUES (2, 0,'Fest', 1, 'Ozernaya', '84950000002');

INSERT INTO User (
        id, version, first_name, middle_name, last_name, position, phone, office_id, citizenship_id,doc_number )
        VALUES (1, 0, 'Пётр','Петрович','Петров', 'store manager', '89099999999',2, 202, 3309);

INSERT INTO Document_info (
    doc_number, version, doc_date, doc_type, user_id)
    VALUES (3315222555, 0, '14 APRIL 2001', 'Паспорт', 2);

INSERT INTO Document_type (
    doc_type, version, doc_type)
    VALUES ('Паспорт', 0, '20');

INSERT INTO Citizenship (
    id, citizenship_code, version, citizenship_name)
    VALUES (1, '633', 0, 'РФ');