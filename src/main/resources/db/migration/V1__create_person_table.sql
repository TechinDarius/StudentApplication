CREATE TABLE person
(
    pid bigint PRIMARY KEY,
    first_name varchar(255) not null,
    middle_name varchar(255),
    last_name varchar(255) not null,
    email varchar(255),
    phone varchar (255)
);

--Person data

insert into person(pid,first_name,middle_name,last_name,email,phone)
values (1232546, 'test','','Testukas','Test@mail.com','2435678')