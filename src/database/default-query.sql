CREATE DATABASE IF NOT EXISTS java_crud
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;

USE java_crud;

CREATE TABLE IF NOT EXISTS users
(
    id         CHAR(50) NOT NULL,
    name       CHAR(20) NOT NULL,
    created_at timestamp default NULL,
    updated_at timestamp default NULL,
    PRIMARY KEY (id)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;