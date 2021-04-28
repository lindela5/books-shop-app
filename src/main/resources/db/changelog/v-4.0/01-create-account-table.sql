--liquibase formatted sql
--changeset sinitsa:01-create-account-table


CREATE TABLE account
(
    id         int   NOT NULL,
    username VARCHAR(100) NOT NULL,
    password  VARCHAR(250) NOT NULL,
    email VARCHAR(50),
    roles VARCHAR (20),
    status VARCHAR(20),

    PRIMARY KEY (id)
);
GO


--rollback DROP TABLE IF EXISTS account CASCADE;
