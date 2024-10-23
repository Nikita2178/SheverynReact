create table rooms
(
    id bigint generated always as identity primary key not null,
    room_name varchar(100) not null,
    room_type varchar(100) not null,
    price numeric(10, 2) not null,
    available_from date not null,
    available_to date not null
);

create table reservations
(
    id bigint generated always as identity primary key not null,
    user_id bigint not null,
    room_id bigint not null,
    user_name varchar(100) not null,
    user_surname varchar(100) not null,
    check_in_date date not null,
    check_out_date date not null,
    total_price numeric(10, 2) not null
);

ALTER TABLE reservations
    ADD CONSTRAINT fk_room_id
        FOREIGN KEY (room_id) REFERENCES rooms(id);

ALTER TABLE reservations
    ADD CONSTRAINT fk_user_id
        FOREIGN KEY (user_id) REFERENCES users(id);
