INSERT INTO users (username, password) VALUES ('1111', '1111');
INSERT INTO users (username, password) VALUES ('2222', '2222');
INSERT INTO roles (name) VALUES ('ROLE_USER');
INSERT INTO roles (name) VALUES ('ROLE_ADMIN');
INSERT INTO roles_has_users (user_id, role_id) VALUES (1, 1);
INSERT INTO roles_has_users (user_id, role_id) VALUES (1, 2);
INSERT INTO roles_has_users (user_id, role_id) VALUES (2, 1);

UPDATE roles
SET name = 'ROLE_ADMIN'
WHERE id = 1;

UPDATE roles
SET name = 'ROLE_ADMIN'
WHERE id = 2;
