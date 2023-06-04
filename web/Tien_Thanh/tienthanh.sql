create database tien_thanh;
use tien_thanh;
-- SELECT * FROM android_phone WHERE start_Date < '2023-04-22';

alter table android_phone add name_of_the_phone text;

CREATE TABLE LichSuThayDoi (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Action VARCHAR(10),
    ThoiGianChinhSua TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    DuLieuCu JSON,
    DuLieuMoi JSON
);

ALTER TABLE android_phone
ADD COLUMN phone_number_owner TEXT AFTER start_Date;


create table android_phone(
	id varchar(20) primary key,
    name_owner text,
    name_phone text,
    id_of_phone text,
    price int,
    start_Date date,
    phone_number_owner text,
    status text,
    password text,
    note text
);
INSERT INTO `tien_thanh`.`android_phone` (`id`, `name_owner`, `name_phone`, `price`, `start_Date`, `status`, `password`, `note`) VALUES ('0000101', 'bbbb', 'samsung', '12322', '2023-04-26', 'dsdf', 'd', 'd');
INSERT INTO `tien_thanh`.`android_phone` (`id`, `name_owner`, `price`, `start_Date`, `status`, `password`, `note`) VALUES ('1', 'gg', '213123', '2023-04-25', 'áda', 's', 's');
INSERT INTO `tien_thanh`.`android_phone` (`id`, `name_owner`, `name_phone`, `price`, `start_Date`, `status`, `password`, `note`) VALUES ('2222', 'b', '0090993256', '4444', '2004-09-04', 'bình thường', '555', 'b');
INSERT INTO `tien_thanh`.`android_phone` (`id`, `name_owner`, `name_phone`, `price`, `start_Date`, `status`, `password`, `note`) VALUES ('2222222', 'ndd', 'samsung', '123', '2023-04-25', 'đ', 'đ', 'đ');
INSERT INTO `tien_thanh`.`android_phone` (`id`, `name_owner`, `name_phone`, `price`, `start_Date`, `status`, `password`, `note`) VALUES ('22222245', 'm', 'samsung', '123', '2023-04-25', 'm', 'm', 'm');
INSERT INTO `tien_thanh`.`android_phone` (`id`, `name_owner`, `price`, `start_Date`, `status`, `password`, `note`) VALUES ('464634', 'n', '2312', '2023-04-29', 'm', 'đ', 'đ');
INSERT INTO `tien_thanh`.`android_phone` (`id`, `name_owner`, `price`, `start_Date`, `status`, `password`, `note`) VALUES ('67676', 'd', '222', '2023-04-25', 'd', 'd', 'd');
INSERT INTO `tien_thanh`.`android_phone` (`id`, `name_owner`, `name_phone`, `price`, `start_Date`, `status`, `password`, `note`) VALUES ('000000000', '33', 'samsung', '3', '2023-05-07', '3', '3', '3');
INSERT INTO `tien_thanh`.`android_phone` (`id`, `name_owner`, `name_phone`, `price`, `start_Date`, `status`, `password`, `note`) VALUES ('0000000000000000001', '1231312', 'samsung', '1', '2023-05-27', '2', '2', '');
INSERT INTO `tien_thanh`.`android_phone` (`id`, `name_owner`, `name_phone`, `price`, `start_Date`, `status`, `password`, `note`) VALUES ('0001', '001', 'samsung', '1', '1111-01-01', '11', '1', '1');
INSERT INTO `tien_thanh`.`android_phone` (`id`, `name_owner`, `name_phone`, `price`, `start_Date`, `status`, `password`, `note`) VALUES ('000101010101', '1', 'samsung', '1', '2023-05-09', '1', '1', '1');
INSERT INTO `tien_thanh`.`android_phone` (`id`, `name_owner`, `name_phone`, `price`, `start_Date`, `status`, `password`, `note`) VALUES ('00011', '1', 'samsung', '1', '2023-05-09', 'Bình thường', 'Không có', 'Không có');
INSERT INTO `tien_thanh`.`android_phone` (`id`, `name_owner`, `name_phone`, `price`, `start_Date`, `status`, `password`, `note`) VALUES ('00012', '1', 'samsung', '1', '2023-05-09', '1', '123131231', 'm');
INSERT INTO `tien_thanh`.`android_phone` (`id`, `name_owner`, `name_phone`, `price`, `start_Date`, `status`, `password`, `note`) VALUES ('00014', '1', 'samsung', '113000', '2023-05-09', 'Bình thường', 'Không có', 'Không có');
INSERT INTO `tien_thanh`.`android_phone` (`id`, `name_owner`, `name_phone`, `price`, `start_Date`, `status`, `password`, `note`) VALUES ('00015', '1', 'samsung', '12391023', '2023-05-09', '1', 'Không có', 'Không có');
INSERT INTO `tien_thanh`.`android_phone` (`id`, `name_owner`, `name_phone`, `price`, `start_Date`, `status`, `password`, `note`) VALUES ('00016', '1', 'samsung', '1111111', '2023-05-09', 'Bình thường', 'Không có', 'Không có');
INSERT INTO `tien_thanh`.`android_phone` (`id`, `name_owner`, `name_phone`, `price`, `start_Date`, `status`, `password`, `note`) VALUES ('00017', '11', 'samsung', '1', '2023-05-09', 'Bình thường', 'Không có', 'Không có');
INSERT INTO `tien_thanh`.`android_phone` (`id`, `name_owner`, `name_phone`, `price`, `start_Date`, `status`, `password`, `note`) VALUES ('00018', '1', 'samsung', '1', '2023-05-09', 'Bình thường', 'Không có', 'Không có');
INSERT INTO `tien_thanh`.`android_phone` (`id`, `name_owner`, `name_phone`, `price`, `start_Date`, `status`, `password`, `note`) VALUES ('00019', '1', 'samsung', '1', '2023-05-09', 'Bình thường', 'Không có', 'Không có');
INSERT INTO `tien_thanh`.`android_phone` (`id`, `name_owner`, `name_phone`, `price`, `start_Date`, `status`, `password`, `note`) VALUES ('00020', '1', 'samsung', '1', '2023-05-09', 'Bình thường', 'Không có', 'Không có');
INSERT INTO `tien_thanh`.`android_phone` (`id`, `name_owner`, `name_phone`, `price`, `start_Date`, `status`, `password`, `note`) VALUES ('009', '9', 'samsung', '9', '2023-05-08', '99', '19', '9');
INSERT INTO `tien_thanh`.`android_phone` (`id`, `name_owner`, `name_phone`, `price`, `start_Date`, `status`, `password`, `note`) VALUES ('1112111', '11', 'samsung', '1', '2023-05-09', '', '', '');
INSERT INTO `tien_thanh`.`android_phone` (`id`, `name_owner`, `name_phone`, `price`, `start_Date`, `status`, `password`, `note`) VALUES ('1231231222', '1', 'samsung', '1', '2023-05-07', '1', '1', '1');
INSERT INTO `tien_thanh`.`android_phone` (`id`, `name_owner`, `name_phone`, `price`, `start_Date`, `status`, `password`, `note`) VALUES ('444444444444444', '4', 'ddddd', '4', '2023-05-07', '4', '4', '4');
INSERT INTO `tien_thanh`.`android_phone` (`id`, `name_owner`, `price`, `start_Date`, `status`, `password`, `note`) VALUES ('4445', 'h', '3434', '2023-04-25', 'dsdf', 'sdfsf', 'sdfs');
INSERT INTO `tien_thanh`.`android_phone` (`id`, `name_owner`, `price`, `start_Date`, `status`, `password`, `note`) VALUES ('45646', 'ww', '222', '2023-04-13', 'đ', 's', 's');
INSERT INTO `tien_thanh`.`android_phone` (`id`, `name_owner`, `name_phone`, `price`, `start_Date`, `status`, `password`, `note`) VALUES ('456464333', 'q', 'gggg', '213', '2023-04-26', 'ád', 'ss', 'ss');
INSERT INTO `tien_thanh`.`android_phone` (`id`, `name_owner`, `name_phone`, `price`, `start_Date`, `status`, `password`, `note`) VALUES ('766666666666666666', '6', 'oppo', '6', '2023-05-07', '6', '6', '6');
INSERT INTO `tien_thanh`.`android_phone` (`id`, `name_owner`, `name_phone`, `price`, `start_Date`, `status`, `password`, `note`) VALUES ('777777777777', '7', 'samsung', '7', '2023-05-07', '7', '7', '7');





INSERT INTO `tien_thanh`.`android_phone` (`id`, `name_owner`, `name_phone`, `id_of_phone`, `price`, `start_Date`, `phone_number_owner`, `status`, `password`, `note`) VALUES ('0000101', 'bbbb', 'samsung', '1', '1232200', '2023-04-26', '0935444445', 'dsdf', 'd', 'd');
INSERT INTO `tien_thanh`.`android_phone` (`id`, `name_owner`, `name_phone`, `id_of_phone`, `price`, `start_Date`, `phone_number_owner`, `status`, `password`, `note`) VALUES ('000101010101', '1', 'samsung', '2', '1000000', '2023-05-09', '0935444445', '1', '1', '1');
INSERT INTO `tien_thanh`.`android_phone` (`id`, `name_owner`, `name_phone`, `id_of_phone`, `price`, `start_Date`, `phone_number_owner`, `status`, `password`, `note`) VALUES ('00011', 'tii', 'oppo', '3', '1122389', '2023-05-26', '0935444445', 'Bình thường', 'Không có', 'Không có');
INSERT INTO `tien_thanh`.`android_phone` (`id`, `name_owner`, `name_phone`, `id_of_phone`, `price`, `start_Date`, `phone_number_owner`, `status`, `password`, `note`) VALUES ('00015', '1', 'samsung', '4', '1239102', '2023-05-09', '0935444445', '1', 'Không có', 'Không có');
INSERT INTO `tien_thanh`.`android_phone` (`id`, `name_owner`, `name_phone`, `id_of_phone`, `price`, `start_Date`, `phone_number_owner`, `status`, `password`, `note`) VALUES ('00016', '1', 'samsung', '5', '1111111', '2023-05-09', '0935444445', 'Bình thường', 'Không có', 'Không có');
INSERT INTO `tien_thanh`.`android_phone` (`id`, `name_owner`, `name_phone`, `id_of_phone`, `price`, `start_Date`, `phone_number_owner`, `status`, `password`, `note`) VALUES ('00017', '11', 'samsung', '6', '1000098', '2023-05-09', '0935444445', 'Bình thường', 'Không có', 'Không có');
INSERT INTO `tien_thanh`.`android_phone` (`id`, `name_owner`, `name_phone`, `id_of_phone`, `price`, `start_Date`, `phone_number_owner`, `status`, `password`, `note`) VALUES ('00018', '1', 'samsung', '7', '1000000', '2023-05-09', '0935444445', 'Bình thường', 'Không có', 'Không có');
INSERT INTO `tien_thanh`.`android_phone` (`id`, `name_owner`, `name_phone`, `id_of_phone`, `price`, `start_Date`, `phone_number_owner`, `status`, `password`, `note`) VALUES ('00019', '1', 'samsung', '8', '1000000', '2023-05-09', '0935444445', 'Bình thường', 'Không có', 'Không có');
INSERT INTO `tien_thanh`.`android_phone` (`id`, `name_owner`, `name_phone`, `id_of_phone`, `price`, `start_Date`, `phone_number_owner`, `status`, `password`, `note`) VALUES ('00020', '1', 'samsung', '9', '1000000', '2023-05-09', '0935444445', 'Bình thường', 'Không có', 'Không có');
INSERT INTO `tien_thanh`.`android_phone` (`id`, `name_owner`, `name_phone`, `id_of_phone`, `price`, `start_Date`, `phone_number_owner`, `status`, `password`, `note`) VALUES ('00021', '1', 'oppo', '10', '1000000', '2023-05-10', '0935444445', 'Bình thường', 'Không có', 'Không có');
INSERT INTO `tien_thanh`.`android_phone` (`id`, `name_owner`, `name_phone`, `id_of_phone`, `price`, `start_Date`, `phone_number_owner`, `status`, `password`, `note`) VALUES ('00022', '2', 'phone', '11', '2000000', '2023-05-10', '0935444445', 'Bình thường', 'Không có', 'Không có');
INSERT INTO `tien_thanh`.`android_phone` (`id`, `name_owner`, `name_phone`, `id_of_phone`, `price`, `start_Date`, `phone_number_owner`, `status`, `password`, `note`) VALUES ('00023', 'j', 'phone', '12', '1300000', '2023-05-10', '0935444445', 'Bình thường', 'Không có', 'Không có');
INSERT INTO `tien_thanh`.`android_phone` (`id`, `name_owner`, `name_phone`, `id_of_phone`, `price`, `start_Date`, `phone_number_owner`, `status`, `password`, `note`) VALUES ('00024', 'k', 'phone', '13', '1122300', '2023-05-10', '0935444445', 'Bình thường', 'Không có', 'Không có');
INSERT INTO `tien_thanh`.`android_phone` (`id`, `name_owner`, `name_phone`, `id_of_phone`, `price`, `start_Date`, `phone_number_owner`, `status`, `password`, `note`) VALUES ('00025', 'j', 'phone', '14', '1239999', '2023-05-10', '0935444445', 'Bình thường', 'Không có', 'Không có');
INSERT INTO `tien_thanh`.`android_phone` (`id`, `name_owner`, `name_phone`, `id_of_phone`, `price`, `start_Date`, `phone_number_owner`, `status`, `password`, `note`) VALUES ('00027', '2', 'samsung', '15', '2500000', '2023-05-10', '0935444445', 'Bình thường', 'Không có', 'Không có');
INSERT INTO `tien_thanh`.`android_phone` (`id`, `name_owner`, `name_phone`, `id_of_phone`, `price`, `start_Date`, `phone_number_owner`, `status`, `password`, `note`) VALUES ('00028', '1', '', '16', '1000000', '2023-05-10', '0935444445', 'Bình thường', 'Không có', 'Không có');
INSERT INTO `tien_thanh`.`android_phone` (`id`, `name_owner`, `name_phone`, `id_of_phone`, `price`, `start_Date`, `phone_number_owner`, `status`, `password`, `note`) VALUES ('001', 'tien', 'oppo', '17', '1110000', '2023-05-26', '0935444445', 'Bình thường', 'Không có', 'Không có');
INSERT INTO `tien_thanh`.`android_phone` (`id`, `name_owner`, `name_phone`, `id_of_phone`, `price`, `start_Date`, `phone_number_owner`, `status`, `password`, `note`) VALUES ('009', '9', 'samsung', '18', '9000000', '2023-05-08', '0935444445', '99', '19', '9');
INSERT INTO `tien_thanh`.`android_phone` (`id`, `name_owner`, `name_phone`, `id_of_phone`, `price`, `start_Date`, `phone_number_owner`, `status`, `password`, `note`) VALUES ('1112111', '11', 'samsung', '19', '9000000', '2023-05-09', '0935444445', '', '', '');
INSERT INTO `tien_thanh`.`android_phone` (`id`, `name_owner`, `name_phone`, `id_of_phone`, `price`, `start_Date`, `phone_number_owner`, `status`, `password`, `note`) VALUES ('1231231222', '1', 'samsung', '20', '8000000', '2023-05-07', '0935444445', '1', '1', '1');
INSERT INTO `tien_thanh`.`android_phone` (`id`, `name_owner`, `name_phone`, `id_of_phone`, `price`, `start_Date`, `phone_number_owner`, `status`, `password`, `note`) VALUES ('2222', 'b', '0090993256', '21', '4444000', '2004-09-04', '0935444445', 'bình thường', '555', 'b');
INSERT INTO `tien_thanh`.`android_phone` (`id`, `name_owner`, `name_phone`, `id_of_phone`, `price`, `start_Date`, `phone_number_owner`, `status`, `password`, `note`) VALUES ('2222222', 'ndd', 'samsung', '22', '1230000', '2023-04-25', '0935444445', 'đ', 'đ', 'đ');
INSERT INTO `tien_thanh`.`android_phone` (`id`, `name_owner`, `name_phone`, `id_of_phone`, `price`, `start_Date`, `phone_number_owner`, `status`, `password`, `note`) VALUES ('444444444444444', '4', 'ddddd', '23', '4000000', '2023-05-07', '0935444445', '4', '4', '4');
INSERT INTO `tien_thanh`.`android_phone` (`id`, `name_owner`, `id_of_phone`, `price`, `start_Date`, `phone_number_owner`, `status`, `password`, `note`) VALUES ('4445', 'h', '24', '3434000', '2031-07-12', '0935444445', 'dsdf', 'sdfsf', 'sdfs');
INSERT INTO `tien_thanh`.`android_phone` (`id`, `name_owner`, `id_of_phone`, `price`, `start_Date`, `phone_number_owner`, `status`, `password`, `note`) VALUES ('45646', 'ww', '25', '2220000', '2023-04-13', '0935444445', 'đ', 's', 's');
INSERT INTO `tien_thanh`.`android_phone` (`id`, `name_owner`, `name_phone`, `id_of_phone`, `price`, `start_Date`, `phone_number_owner`, `status`, `password`, `note`) VALUES ('456464333', 'q', 'gggg', '26', '2130000', '2023-04-26', '0935444445', 'ád', 'ss', 'ss');
INSERT INTO `tien_thanh`.`android_phone` (`id`, `name_owner`, `id_of_phone`, `price`, `start_Date`, `phone_number_owner`, `status`, `password`, `note`) VALUES ('464634', 'n', '27', '2312000', '2023-04-29', '0935444445', 'm', 'đ', 'đ');
INSERT INTO `tien_thanh`.`android_phone` (`id`, `name_owner`, `id_of_phone`, `price`, `start_Date`, `phone_number_owner`, `status`, `password`, `note`) VALUES ('67676', 'd', '28', '2220000', '2023-04-25', '0935444445', 'd', 'd', 'd');
INSERT INTO `tien_thanh`.`android_phone` (`id`, `name_owner`, `name_phone`, `id_of_phone`, `price`, `start_Date`, `phone_number_owner`, `status`, `password`, `note`) VALUES ('766666666666666666', '6', 'oppo', '29', '6000000', '2023-05-07', '0935444445', '6', '6', '6');
INSERT INTO `tien_thanh`.`android_phone` (`id`, `name_owner`, `name_phone`, `id_of_phone`, `price`, `start_Date`, `phone_number_owner`, `status`, `password`, `note`) VALUES ('777777777777', '7', 'samsung', '30', '7000000', '2023-05-07', '0935444445', '7', '7', '7');

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
