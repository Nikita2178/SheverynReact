create table users
(
    id bigint generated always as identity primary key not null,
    username varchar(100),
    password varchar(100),
    name varchar(100),
    surname varchar(100),
    phone varchar(100)

);
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

SELECT * FROM users;
