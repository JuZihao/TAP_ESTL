create table employee
(
    id     varchar(255) not null
        primary key,
    login  varchar(255) not null,
    name   varchar(255) not null,
    salary double       not null
);