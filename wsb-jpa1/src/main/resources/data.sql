insert into address (id, city, address_line1, address_line2, postal_code) values
          (1, 'Żary', 'Moniuszki 11', 'lokal 2a', '68-200'),
          (2, 'Żagań', 'Paderewskiego 1', 'lokal 5b', '89-000'),
          (3, 'Żory', 'Wieniawskiego 2', '', '23-123');

insert into doctor (id, doctor_number, email, first_name, last_name, specialization, telephone_number, address_id) values
           (1, 'jj123', 'janowyj@mail.pl', 'Jan', 'Janowy', 'SURGEON', '321321321', 1),
           (2, 'aa321', 'annowskaa@mail.com', 'Anna', 'Annowska', 'SURGEON', '231231231', 2),
           (3, 'jj122', 'jakubowyj@mail.io', 'Jakub', 'Jakubowy', 'SURGEON', '123123123', 3);

insert into doctor_to_address (doctor_id, address_id)
values (1, 1), (2, 3);

insert into patient (id, pesel, date_of_birth, email, first_name, last_name, patient_number, telephone_number, address_id) values
         (1, 123123121, '2000-11-13', 'onomatopeja@mail.com', 'Witold', 'Dlotiw', 'dlab2', '147258369', 1),
         (2, 123123122, '1998-01-03', 'spejsonlegia@mail.pl', 'Spejson', 'Legionista', 'legiato', '789654123', 2),
         (3, 123123123, '1995-04-10', 'wjacek@mail.io', 'Jacek', 'Walaszek', 'walu12', '357159482', 3);

insert into patient_to_address (patient_id, address_id)
values (1, 1), (2, 2);

insert into visit (id, description, time, doctor_id, patient_id)
values (1, 'Badanie serca', '2022-02-21 22:45:36', 1, 1),
       (2, 'Badanie kału', '2020-12-24 3:55:21', 1, 2),
       (3, 'Gastroskopia', '2021-03-18 15:59:45', 3, 2),
       (4, 'Badanie nogi', '2023-01-20 12:01:37', 3, 3);

insert into medical_treatment (id, description, type, visit_id)
values (1, 'Badanie serca bezdomnego', 'USG', 1),
       (2, 'Sprawdzenie substancji radioaktywnych w kale', 'EKG', 2),
       (3, 'Szukanie obcych ciałek', 'USG', 2),
       (4, 'Sprawdzenie kolana', 'USG', 3);

SELECT p.*, COUNT(v.id) AS visits_count
FROM patient p
         JOIN visit v ON p.id = v.patient_id
GROUP BY p.id
HAVING visits_count > 0;

SELECT * FROM patient WHERE last_name = 'Legionista';

SELECT * FROM visit WHERE patient_id = 3;

SELECT * FROM patient WHERE pesel > 123123122;