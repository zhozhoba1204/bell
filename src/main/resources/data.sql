INSERT INTO Organization (
        id, version, name, full_name, inn, kpp, address, phone, is_active)
        VALUES (1, 0, 'Polo', 'US POLO', '111', '222', 'Msk', '84950000001', true);

INSERT INTO Office (
        id, version, name, org_id, address, phone, is_active)
        VALUES (2, 0,'Fest', 1, 'Ozernaya', '84950000002', true);

INSERT INTO Citizenship (
    id, citizenship_code, version, citizenship_name)
VALUES (1, '633', 0, 'РФ');

INSERT INTO Usr (
        id, version, first_name, middle_name, last_name, position, phone, office_id, citizenship_id,is_identified )
        VALUES (1, 0, 'Пётр','Петрович','Петров', 'store manager', '89099999999',2, 1,true);

INSERT INTO Document_type (
    doc_name, version, doc_code)
VALUES ('Паспорт', 0, '20');

INSERT INTO Document_info (
    user_id, doc_number, version, doc_date, doc_name)
    VALUES (1,3315222555, 0, '14 APRIL 2001', 'Паспорт');



