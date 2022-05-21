--liquibase formatted sql

--changeset trashkova:1
insert into socks (color, cotton_part, quantity)
values
('red', 10, 100),
('red', 30, 100),
('red', 50, 100),
('red', 70, 100),
('black', 80, 100),
('black', 20, 100);
