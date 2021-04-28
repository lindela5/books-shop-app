--liquibase formatted sql
--changeset sinitsa:05-insert-account-table


INSERT INTO account (id, username, password, email, roles, status) VALUES
(1, 'admin','$2y$12$fi1DJkSRQrUvENO1.FEzKOeOTotpUrKcVrvmhYXDD2qmPn6nJEsq2','admin@mail.ru','ADMIN','ACTIVE' ),
(2, 'user', '$2y$12$uyr.VT.6AJ5xIxDmyVCR3O1v0fjFRhdLrqGkrrbgHCeSpx9t35xQ2','user@gsu.by','USER','ACTIVE');
GO



--rollback DELETE FROM account;