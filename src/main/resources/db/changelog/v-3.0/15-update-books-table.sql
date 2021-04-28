--liquibase formatted sql
--changeset sinitsa:15-update-books-table.sql


UPDATE books SET picture = 'https://i.ibb.co/h1Tgs1k/65373096-1.jpg'
WHERE book_id = 1;
GO

UPDATE books SET picture = 'https://i.ibb.co/h1Tgs1k/65373096-1.jpg'
WHERE book_id = 3;
GO


UPDATE books SET picture = 'https://i.ibb.co/h1Tgs1k/65373096-1.jpg'
WHERE book_id = 5;
GO


UPDATE books SET picture = 'https://i.ibb.co/h1Tgs1k/65373096-1.jpg'
WHERE book_id = 7;
GO


UPDATE books SET picture = 'https://i.ibb.co/h1Tgs1k/65373096-1.jpg'
WHERE book_id = 9;
GO


UPDATE books SET picture = 'https://i.ibb.co/h1Tgs1k/65373096-1.jpg'
WHERE book_id = 11;
GO

UPDATE books SET picture = 'https://i.ibb.co/h1Tgs1k/65373096-1.jpg'
WHERE book_id = 13;
GO


UPDATE books SET picture = 'https://i.ibb.co/h1Tgs1k/65373096-1.jpg'
WHERE book_id = 15;
GO


--rollback UPDATE books SET picture = NULL WHERE book_id = 15;
--rollback UPDATE books SET picture = NULL WHERE book_id = 13;
--rollback UPDATE books SET picture = NULL WHERE book_id = 11;
--rollback UPDATE books SET picture = NULL WHERE book_id = 9;
--rollback UPDATE books SET picture = NULL WHERE book_id = 7;
--rollback UPDATE books SET picture = NULL WHERE book_id = 5;
--rollback UPDATE books SET picture = NULL WHERE book_id = 3;
--rollback UPDATE books SET picture = NULL WHERE book_id = 1;



