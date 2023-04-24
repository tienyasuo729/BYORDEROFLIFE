create database tien_thanh;
use tien_thanh;

create table android_phone(
	id varchar(20) primary key,
    name_owner text,
    name_phone text,
    price int,
    start_Date date,
    status text,
    password text,
    note text
);


-- create table detail(
-- 	idDetail varchar(20) primary key,
--     name text,
--     birthday date,
--     gender text,
--     address text,
--     phoneNumber text,
-- 	times int,
-- 	history text
-- );

-- create table motorbike(
-- 	cccd varchar(20) primary key,
--     name_cccd text,
--     type text,
--     name_owner_bike text,
--     license_Plates text,
--     price int,
--     startDate date,
--     checkForDetail int
-- );

-- INSERT INTO `tien_thanh`.`cccd` (`cccd`, `name`, `price`, `startDate`, `checkForDetail`) VALUES ('049203002003', 'Trần phước nhật tiến', '150000', '2023-04-17', '1');
-- INSERT INTO `tien_thanh`.`detail` (`idDetail`, `name`, `birthday`, `gender`, `address`, `phoneNumber`, `times`, `history`) VALUES ('049203002003', 'Trần phước nhật tiến', '2003-04-22', 'nam', 'thị trấn Đông Phú, Huyện Quế Sơn, Tỉnh Quảng Nam', '0935430002', '0', 'Không có');
-- INSERT INTO `tien_thanh`.`cccd` (`cccd`, `name`, `price`, `startDate`, `checkForDetail`) VALUES ('049203002002', 'a', '120000', '2023-04-18', '0');
-- INSERT INTO `tien_thanh`.`cccd` (`cccd`, `name`, `price`, `startDate`, `checkForDetail`) VALUES ('049203002004', 'b', '160000', '2023-04-14', '0');
-- INSERT INTO `tien_thanh`.`cccd` (`cccd`, `name`, `price`, `startDate`, `checkForDetail`) VALUES ('049203002005', 'c', '190000', '2023-04-12', '1');

-- INSERT INTO `tien_thanh`.`detail` (`idDetail`, `name`, `birthday`, `gender`, `address`, `phoneNumber`, `times`, `history`) VALUES ('049203002002', 'a', '2003-04-22', 'nam', 'thị trấn Đông Phú, Huyện Quế Sơn, Tỉnh Quảng Nam', '0935430002', '11', 'Không có');
-- INSERT INTO `tien_thanh`.`detail` (`idDetail`, `name`, `birthday`, `gender`, `address`, `phoneNumber`, `times`, `history`) VALUES ('049203002004', 'b', '2004-05-07', 'nam', 'thị trấn Đông Phú, Huyện Quế Sơn, Tỉnh Quảng Nam', '0935430002', '1', 'có');
-- INSERT INTO `tien_thanh`.`detail` (`idDetail`, `name`, `birthday`, `gender`, `address`, `phoneNumber`, `times`, `history`) VALUES ('049203002005', 'c', '2007-04-30', 'nam', 'thị trấn Đông Phú, Huyện Quế Sơn, Tỉnh Quảng Nam', '0935430002', '0', 'có');
