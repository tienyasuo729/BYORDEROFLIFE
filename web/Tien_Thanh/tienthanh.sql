create database tien_thanh;
use tien_thanh;

create table detail(
	idDetail varchar(20) primary key,
    name text,
    birthday date,
    sex text,
    address text,
    phoneNumber text,
	times int,
	history text
);

create table cccd(
	cccd varchar(20) primary key,
    name text,	
    price int,
    startDate date
    );
