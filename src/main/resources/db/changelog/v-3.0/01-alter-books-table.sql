--liquibase formatted sql
--changeset sinitsa:01-insert-books-table


ALTER TABLE books ADD COLUMN picture VARCHAR(200);
GO

--rollback ALTER TABLE books DROP COLUMN picture;

