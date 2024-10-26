alter table users
    add username varchar(100);
alter table users
    add password varchar(100);
create table roles
(
    id bigint generated always as identity primary key not null,
    name varchar(100)
);
create table roles_has_users
(
    id bigint generated always as identity primary key not null,
    user_id bigint,
    role_id bigint
);
ALTER TABLE roles_has_users
    ADD CONSTRAINT fk_user_id
        FOREIGN KEY (user_id) REFERENCES users(id);
ALTER TABLE roles_has_users
    ADD CONSTRAINT fk_role_id
        FOREIGN KEY (role_id) REFERENCES roles(id);


SELECT users.id, users.username, users.password, roles.name AS role
FROM users
         JOIN roles_has_users ON users.id = roles_has_users.user_id
         JOIN roles ON roles_has_users.role_id = roles.id
WHERE users.username = '1111';

SELECT * FROM users;
SELECT * FROM roles;
SELECT * FROM roles_has_users;

SELECT u.username, r.name AS role
FROM users u
         JOIN roles_has_users ru ON u.id = ru.user_id
         JOIN roles r ON ru.role_id = r.id;


SELECT username, password FROM users;

-- Оновлення пароля для користувача 1
UPDATE users SET password = '$2a$10$IJwCYhASTMu4AhKN9IV8a.qkhR0Pmd2NV/6dtbCc0PsfUVwPgDNOW' WHERE username = '1111';

-- Оновлення пароля для користувача 2
UPDATE users SET password = '$2a$10$0ix1S9xi9O1p8JV7wyGBz.3RB9ultVx9TZ488.TnFe7l3v0HBPM6m' WHERE username = '2222';
DELETE FROM roles_has_users
WHERE id NOT IN (
    SELECT MIN(id)
    FROM users
    GROUP BY username
);
INSERT INTO roles_has_users (user_id, role_id) VALUES ((SELECT id FROM users WHERE username = '1111'), (SELECT id FROM roles WHERE name = 'ROLE_USER'));

SELECT users.username, users.password, roles.name AS role
FROM users
         JOIN roles_has_users ON users.id = roles_has_users.user_id
         JOIN roles ON roles_has_users.role_id = roles.id;


INSERT INTO rooms (room_name, room_type, price, available_from, available_to)
VALUES (:roomName, :roomType, :price, :availableFrom, :availableTo);


CREATE TABLE guest (
                       id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                       name VARCHAR(100) NOT NULL,
                       email VARCHAR(100) NOT NULL,
                       phone VARCHAR(15) NOT NULL
);
