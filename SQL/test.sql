create database ss2;
use ss2;
create table VatTu(
	MaVTU varchar(45) primary key,
    TenVTU varchar(45)
);
create table PhieuXuat(
	SoPX varchar(45) primary key,
    NgayXuat date
);
create table PhieuNHap(
	SoPX varchar(45) primary key,
    NgayNhap date
);
create table DonDH(
	SoDH varchar(45) primary key,
    NgayDH date
);
create table NhaCC(
	MaNhaCC varchar(45) primary key,
    TenNhaCC varchar(45),
    DiaChi varchar(100)
);
create table DonXuat(
	SoPX varchar(45),
	MaVTU varchar(45),
	DGXuat int,
    SLXuat int
);
create table SDT (
	SDT mediumint,
    MaNhaCC varchar(10),
    primary key (SDT, MaNhaCC),
    foreign key (SDT) REFERENCES NhaCC(SDT),
    foreign key (MaNhaCC) REFERENCES NhaCC(MaNhaCC)
);





