create table if not exists student (
    id int primary key auto_increment,
    name varchar(30),
    score double,
    graduate boolean,
    create_date timestamp
);