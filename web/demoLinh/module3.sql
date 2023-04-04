create database module3;
use module3;

create table product(
	stt int not null primary key auto_increment,
	name text,
    price int,
    quantity int,
    color text,
    description text,
    category text
);