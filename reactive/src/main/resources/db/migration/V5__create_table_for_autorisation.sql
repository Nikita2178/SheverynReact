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
