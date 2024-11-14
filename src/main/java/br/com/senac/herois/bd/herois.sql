CREATE DATABASE herois;

USE herois;

show create table herois;
ALTER TABLE herois ADD CONSTRAINT fk_equipe_id FOREIGN KEY (equipe_id) REFERENCES equipe (id);
ALTER TABLE herois ADD COLUMN imagem MEDIUMBLOB;
UPDATE herois SET equipe_id = 1 WHERE id IN (1, 2, 3, 6, 8, 10, 12, 14, 19);
UPDATE herois SET equipe_id = 2 WHERE id IN (5, 9, 7, 20, 23);
UPDATE herois SET equipe_id = 3 WHERE id IN (20, 30);
UPDATE herois SET equipe_id = 4 WHERE id IN (11, 15, 18, 21, 24);
UPDATE herois SET equipe_id = 5 WHERE id IN (4, 13, 16, 17, 25, 26, 27, 28, 29);