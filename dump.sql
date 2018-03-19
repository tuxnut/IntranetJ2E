# CREATE DATABASE Intranet;
#
# CREATE TABLE administrator (
#   id_administrator BIGINT(20),
#   email            VARCHAR(255),
#   name             VARCHAR(255),
#   password         VARCHAR(255)
# );
#
#
# CREATE TABLE student (
#   id_student         BIGINT(20),
#   email              VARCHAR(255),
#   name               VARCHAR(255),
#   password           VARCHAR(255),
#   fk_section_student BIGINT(20)
# );
#
# CREATE TABLE section (
#   id_section BIGINT(20),
#   name       VARCHAR(255)
# );
#
# CREATE TABLE teacher (
#   id_teacher BIGINT(20),
#   email      VARCHAR(255),
#   name       VARCHAR(255),
#   password   VARCHAR(255)
# );
#
# CREATE TABLE course (
#   id_course         BIGINT(20),
#   name              VARCHAR(255),
#   fk_section_course BIGINT(20),
#   fk_teacher_course BIGINT(20)
# );
#
# CREATE TABLE news (
#   id_news           BIGINT(20),
#   publication_date  datetime,
#   text              BIGINT(20),
#   title             BIGINT(20)
# );
#
# CREATE TABLE note (
#   id_note           BIGINT(20),
#   value             INT(11),
#   fk_course_note    BIGINT(20),
#   fk_student_note   BIGINT(20)
# );

# administrator

INSERT INTO administrator (id_administrator, email, name, password) VALUES (1, 'jpp@intranet.fr', 'Petit', 'pwd_petit');

# teacher

INSERT INTO teacher (id_teacher, email, name, password) VALUES (1, 'maidi@intranet.fr', 'Maidi', 'pwd_maidi');
INSERT INTO teacher (id_teacher, email, name, password) VALUES (2, 'arcellier@intranet.fr', 'Arcellier', 'pwd_arcellier');
INSERT INTO teacher (id_teacher, email, name, password) VALUES (3, 'marie@intranet.fr', 'Marie', 'pwd_marie');

# Section

INSERT INTO section (id_section, name) VALUES (1, '3CT');
INSERT INTO section (id_section, name) VALUES (2, '3CB');
INSERT INTO section (id_section, name) VALUES (3, '3CI');

# Course

INSERT INTO course (id_course, name, fk_section_course, fk_teacher_course) VALUES (1, 'Vision Temps Réel', 1, 1);
INSERT INTO course (id_course, name, fk_section_course, fk_teacher_course) VALUES (2, 'Base de données', 2, 3);
INSERT INTO course (id_course, name, fk_section_course, fk_teacher_course) VALUES (3, 'Mathématiques financières', 3, 2);

# student

INSERT INTO student (id_student, email, name, password, fk_section_student) VALUES (1, 'abgrall@intranet.fr', 'Abgrall', 'pwd_abgrall', 1);
INSERT INTO student (id_student, email, name, password, fk_section_student) VALUES (2, 'basson@intranet.fr', 'Basson', 'pwd_basson', 1);
INSERT INTO student (id_student, email, name, password, fk_section_student) VALUES (3, 'caminale@intranet.fr', 'Caminale', 'pwd_caminale', 1);
INSERT INTO student (id_student, email, name, password, fk_section_student) VALUES (4, 'carre@intranet.fr', 'Carre', 'pwd_carre', 1);
INSERT INTO student (id_student, email, name, password, fk_section_student) VALUES (5, 'dumont@intranet.fr', 'Dumont', 'pwd_dumont', 1);
INSERT INTO student (id_student, email, name, password, fk_section_student) VALUES (6, 'galerne@intranet.fr', 'Galerne', 'pwd_galerne', 1);
INSERT INTO student (id_student, email, name, password, fk_section_student) VALUES (7, 'gonard@intranet.fr', 'Gonard', 'pwd_gonard', 1);
INSERT INTO student (id_student, email, name, password, fk_section_student) VALUES (8, 'goujon@intranet.fr', 'Goujon', 'pwd_goujon', 1);
INSERT INTO student (id_student, email, name, password, fk_section_student) VALUES (9, 'leflohic@intranet.fr', 'Le Flohic', 'pwd_leflohic', 1);
INSERT INTO student (id_student, email, name, password, fk_section_student) VALUES (10, 'manier@intranet.fr', 'Manier', 'pwd_manier', 1);
INSERT INTO student (id_student, email, name, password, fk_section_student) VALUES (11, 'nabhan@intranet.fr', 'Nabhan', 'pwd_nabhan', 1);
INSERT INTO student (id_student, email, name, password, fk_section_student) VALUES (12, 'vernizeau@intranet.fr', 'Vernizeau', 'pwd_vernizeau', 1);

INSERT INTO student (id_student, email, name, password, fk_section_student) VALUES (13, 'abbasoglu@intranet.fr', 'Abbasoglu', 'pwd_abbasoglu', 2);
INSERT INTO student (id_student, email, name, password, fk_section_student) VALUES (14, 'catel@intranet.fr', 'Catel', 'pwd_catel', 2);
INSERT INTO student (id_student, email, name, password, fk_section_student) VALUES (15, 'duforest@intranet.fr', 'Duforest', 'pwd_duforest', 2);
INSERT INTO student (id_student, email, name, password, fk_section_student) VALUES (16, 'ferrari@intranet.fr', 'Ferrari', 'pwd_ferrari', 2);
INSERT INTO student (id_student, email, name, password, fk_section_student) VALUES (17, 'lepape@intranet.fr', 'Le Pape', 'pwd_lepape', 2);
INSERT INTO student (id_student, email, name, password, fk_section_student) VALUES (18, 'martin@intranet.fr', 'Martin', 'pwd_martin', 2);
INSERT INTO student (id_student, email, name, password, fk_section_student) VALUES (19, 'nicol@intranet.fr', 'Nicol', 'pwd_nicol', 2);
INSERT INTO student (id_student, email, name, password, fk_section_student) VALUES (20, 'robert@intranet.fr', 'Robert', 'pwd_robert', 2);
INSERT INTO student (id_student, email, name, password, fk_section_student) VALUES (21, 'rodriguez@intranet.fr', 'Rodriguez', 'pwd_rodriguez', 2);
INSERT INTO student (id_student, email, name, password, fk_section_student) VALUES (22, 'vanacker@intranet.fr', 'Vanacker', 'pwd_vanacker', 2);

INSERT INTO student (id_student, email, name, password, fk_section_student) VALUES (23, 'aitbelaid@intranet.fr', 'Ait Belaid', 'pwd_aitbelaid', 3);
INSERT INTO student (id_student, email, name, password, fk_section_student) VALUES (24, 'busato@intranet.fr', 'Busato', 'pwd_busato', 3);
INSERT INTO student (id_student, email, name, password, fk_section_student) VALUES (25, 'danselme@intranet.fr', 'D/''Anselme', 'pwd_danselme', 3);
INSERT INTO student (id_student, email, name, password, fk_section_student) VALUES (26, 'dagher@intranet.fr', 'Dagher', 'pwd_dagher', 3);
INSERT INTO student (id_student, email, name, password, fk_section_student) VALUES (27, 'djerbi@intranet.fr', 'Djerbi', 'pwd_djerbi', 3);
INSERT INTO student (id_student, email, name, password, fk_section_student) VALUES (28, 'gautier@intranet.fr', 'Gautier De Charnace', 'pwd_gautier', 3);
INSERT INTO student (id_student, email, name, password, fk_section_student) VALUES (29, 'haddad@intranet.fr', 'Haddad', 'pwd_haddad', 3);
INSERT INTO student (id_student, email, name, password, fk_section_student) VALUES (30, 'kreiss@intranet.fr', 'Kreiss', 'pwd_kreiss', 3);
INSERT INTO student (id_student, email, name, password, fk_section_student) VALUES (31, 'mankouri@intranet.fr', 'Mankouri', 'pwd_mankouri', 3);
INSERT INTO student (id_student, email, name, password, fk_section_student) VALUES (32, 'marchand@intranet.fr', 'Marchand', 'pwd_marchand', 3);
INSERT INTO student (id_student, email, name, password, fk_section_student) VALUES (33, 'marin@intranet.fr', 'Marin', 'pwd_marin', 3);
INSERT INTO student (id_student, email, name, password, fk_section_student) VALUES (34, 'nguyen@intranet.fr', 'Nguyen', 'pwd_nguyen', 3);
INSERT INTO student (id_student, email, name, password, fk_section_student) VALUES (35, 'perez@intranet.fr', 'Perez', 'pwd_perez', 3);
INSERT INTO student (id_student, email, name, password, fk_section_student) VALUES (36, 'sarfraz@intranet.fr', 'Sarfraz', 'pwd_sarfraz', 3);
INSERT INTO student (id_student, email, name, password, fk_section_student) VALUES (37, 'sebaoni@intranet.fr', 'Sebaoni', 'pwd_sebaoni', 3);
INSERT INTO student (id_student, email, name, password, fk_section_student) VALUES (38, 'sokolski@intranet.fr', 'Sokolski', 'pwd_sokolski', 3);
INSERT INTO student (id_student, email, name, password, fk_section_student) VALUES (39, 'younes@intranet.fr', 'Younes', 'pwd_younes', 3);
INSERT INTO student (id_student, email, name, password, fk_section_student) VALUES (40, 'zhou@intranet.fr', 'Zhou', 'pwd_zhou', 3);

# news

INSERT INTO news (id_news, publication_date, text, title) VALUES (1, '2018-01-01 10:34:00', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec ut ipsum lorem. Curabitur posuere lorem lorem, id mattis metus convallis eget. Nunc venenatis dapibus erat, vel euismod dolor interdum nec. Mauris sit amet tincidunt ligula, vitae nullam.', 'Bonne Année');
INSERT INTO news (id_news, publication_date, text, title) VALUES (2, '2018-01-02 11:26:00', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec ut ipsum lorem. Curabitur posuere lorem lorem, id mattis metus convallis eget. Nunc venenatis dapibus erat, vel euismod dolor interdum nec. Mauris sit amet tincidunt ligula, vitae nullam.', 'Joyeuse Pâques');
INSERT INTO news (id_news, publication_date, text, title) VALUES (3, '2018-01-03 17:10:00', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec ut ipsum lorem. Curabitur posuere lorem lorem, id mattis metus convallis eget. Nunc venenatis dapibus erat, vel euismod dolor interdum nec. Mauris sit amet tincidunt ligula, vitae nullam.', 'Les vacances !');
INSERT INTO news (id_news, publication_date, text, title) VALUES (4, '2018-01-04 07:55:00', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec ut ipsum lorem. Curabitur posuere lorem lorem, id mattis metus convallis eget. Nunc venenatis dapibus erat, vel euismod dolor interdum nec. Mauris sit amet tincidunt ligula, vitae nullam.', 'Soutenances de J2E');
INSERT INTO news (id_news, publication_date, text, title) VALUES (5, '2018-01-05 15:41:00', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec ut ipsum lorem. Curabitur posuere lorem lorem, id mattis metus convallis eget. Nunc venenatis dapibus erat, vel euismod dolor interdum nec. Mauris sit amet tincidunt ligula, vitae nullam.', 'Le Java c`est nul, mais alors le CSS :/');

# notes

INSERT INTO note (id_note, value, fk_course_note, fk_student_note) VALUES (1, 12, 1, 1);
INSERT INTO note (id_note, value, fk_course_note, fk_student_note) VALUES (2, 09, 2, 1);
INSERT INTO note (id_note, value, fk_course_note, fk_student_note) VALUES (3, 12, 1, 2);
INSERT INTO note (id_note, value, fk_course_note, fk_student_note) VALUES (4, 09, 2, 2);
INSERT INTO note (id_note, value, fk_course_note, fk_student_note) VALUES (5, 12, 1, 3);
INSERT INTO note (id_note, value, fk_course_note, fk_student_note) VALUES (6, 09, 2, 3);
INSERT INTO note (id_note, value, fk_course_note, fk_student_note) VALUES (7, 12, 1, 4);
INSERT INTO note (id_note, value, fk_course_note, fk_student_note) VALUES (8, 09, 2, 4);
INSERT INTO note (id_note, value, fk_course_note, fk_student_note) VALUES (9, 12, 1, 5);
INSERT INTO note (id_note, value, fk_course_note, fk_student_note) VALUES (10, 09, 2, 5);
INSERT INTO note (id_note, value, fk_course_note, fk_student_note) VALUES (11, 12, 1, 6);
INSERT INTO note (id_note, value, fk_course_note, fk_student_note) VALUES (12, 09, 2, 6);
INSERT INTO note (id_note, value, fk_course_note, fk_student_note) VALUES (13, 20, 1, 7);
INSERT INTO note (id_note, value, fk_course_note, fk_student_note) VALUES (14, 20, 2, 7);
INSERT INTO note (id_note, value, fk_course_note, fk_student_note) VALUES (15, 12, 1, 8);
INSERT INTO note (id_note, value, fk_course_note, fk_student_note) VALUES (16, 09, 2, 8);
INSERT INTO note (id_note, value, fk_course_note, fk_student_note) VALUES (17, 20, 1, 9);
INSERT INTO note (id_note, value, fk_course_note, fk_student_note) VALUES (18, 20, 2, 9);
INSERT INTO note (id_note, value, fk_course_note, fk_student_note) VALUES (19, 12, 1, 10);
INSERT INTO note (id_note, value, fk_course_note, fk_student_note) VALUES (20, 09, 2, 10);
INSERT INTO note (id_note, value, fk_course_note, fk_student_note) VALUES (21, 12, 1, 11);
INSERT INTO note (id_note, value, fk_course_note, fk_student_note) VALUES (22, 09, 2, 11);
INSERT INTO note (id_note, value, fk_course_note, fk_student_note) VALUES (23, 20, 1, 12);
INSERT INTO note (id_note, value, fk_course_note, fk_student_note) VALUES (24, 20, 2, 12);


INSERT INTO note (id_note, value, fk_course_note, fk_student_note) VALUES (25, 15, 2, 13);
INSERT INTO note (id_note, value, fk_course_note, fk_student_note) VALUES (26, 16, 3, 13);

INSERT INTO note (id_note, value, fk_course_note, fk_student_note) VALUES (5, 05, 2, 21);

