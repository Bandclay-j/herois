CREATE DATABASE herois;

USE herois;

CREATE TABLE herois (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    apelido VARCHAR(255) NOT NULL,
    super_poder VARCHAR(255) NOT NULL,
    fraqueza VARCHAR(255) NOT NULL,
    historia_origem TEXT NOT NULL,
    primeira_aparicao DATE NOT NULL,
    time_id BIGINT NOT NULL
);

CREATE TABLE time {
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
}