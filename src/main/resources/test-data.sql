INSERT INTO Organization (
     version, name, full_name, inn, kpp, address, phone, is_active)
VALUES ( 0, 'Polo', 'US POLO', '111', '222', 'Msk', '8495000000', true),
( 0, 'Sber', 'Sber', '111', '222', 'Msk', '8495000000', true),
( 0, 'Polo', 'US POLO', '111', '222', 'Msk', '8495000000', true);

INSERT INTO Office (
     version, name, org_id, address, phone, is_active)
VALUES ( 0,'Fest', 1, 'Ozernaya', '8495000002', true),
       ( 0,'Rio', 1, 'Ozernaya', '8495000002', true);

INSERT INTO Citizenship (
     citizenship_code, version, citizenship_name)
VALUES ( '633', 0, 'РФ'),
('222',0,'KZ');

INSERT INTO Usr (
    version, first_name, middle_name, last_name, position, phone, office_id, citizenship_id,is_identified )
VALUES ( 0, 'Пётр','Петрович','Петров', 'store manager', '8909999999',2, 1,true),
       ( 0, 'Иван','Иванович','Иванов', 'manager', '8909999999',2, 1,true);

INSERT INTO Document_type (
    doc_name, version, doc_code)
VALUES ('Passport', 0, 20),
       ('zagran',0,30);

INSERT INTO Document_info (
      doc_number, version, doc_date, doc_name)
VALUES (3315222555, 0, '14 APRIL 2001', 'Passport'),
       (13213213,0,'12 APRIL 2000','Passport');



