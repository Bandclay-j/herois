CREATE DATABASE herois;

USE herois;

CREATE TABLE herois (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    apelido VARCHAR(255) NOT NULL,
    superPoder VARCHAR(255) NOT NULL,
    fraqueza VARCHAR(255) NOT NULL,
    historiaOrigem TEXT NOT NULL,
    primeiraAparicao DATE NOT NULL
);