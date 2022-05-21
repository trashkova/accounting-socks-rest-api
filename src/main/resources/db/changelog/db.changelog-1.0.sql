--liquibase formatted sql

--changeset trashkova:1
create table if not exists socks (
    color varchar(20) not null,
    cotton_part int not null check(cotton_part between 0 and 100),
    quantity int not null check(quantity >=0),
    constraint sock_pkey primary key(color, cotton_part)
);
--rollback drop table socks;