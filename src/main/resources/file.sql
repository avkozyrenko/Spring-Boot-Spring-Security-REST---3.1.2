START TRANSACTION;
SET AUTOCOMMIT = 0;
INSERT INTO users (password, username) VALUES ('$2a$10$oAIXEhpu7TOMiXJxWtMuvOCNUYxh0CdZZpAGf3XjjBRCkZVqECcY.', 'user');
SET @user_id = LAST_INSERT_ID();

INSERT INTO roles (role) VALUES ('ROLE_USER');
SET @role_id = LAST_INSERT_ID();

INSERT INTO users_roles (user_id, role_id) VALUES (@user_id, @role_id);

COMMIT;

START TRANSACTION;
SET AUTOCOMMIT = 0;
INSERT INTO users (password, username) VALUES ('$2a$10$.t4IsjVAJOW9al/DFRtyZun7NWf9BLk6VS1Dh64FoKjP6if3W491S', 'admin');
SET @user_id = LAST_INSERT_ID();

INSERT INTO roles (role) VALUES ('ROLE_ADMIN');
SET @role_id = LAST_INSERT_ID();

INSERT INTO users_roles (user_id, role_id) VALUES (@user_id, @role_id);

COMMIT;