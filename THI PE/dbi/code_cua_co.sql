CREATE DATABASE Assign1

USE Assign1

CREATE TABLE PhongBan(
	MaPhong int identity(1, 1),
	TenPhongBan nvarchar(50),
	CONSTRAINT PK_PhongBan PRIMARY KEY (MaPhong)
)

CREATE TABLE NhanVien(
	MaNhanVien varchar(10),
	HoLot nvarchar(50) not null,
	Ten nvarchar(50) not null,
	NgaySinh date,
	GioiTinh nvarchar(50) ,
	DiaChi nvarchar(100),
	Luong decimal(6,2),
	MaPhongBan int,
	CONSTRAINT PK_NhanVien PRIMARY KEY (MaNhanVien),
	CONSTRAINT FK_NhanVien_MaPhongBan FOREIGN KEY (MaPhongBan) REFERENCES PhongBan(MaPhong)
)

ALTER TABLE NhanVien
ADD MaNVQL varchar(10)

ALTER TABLE NhanVien
ADD CONSTRAINT FK_NhanVien_MaNVQL FOREIGN KEY (MaNVQL) REFERENCES NhanVien(MaNhanVien)

ALTER TABLE PhongBan
ADD MaTruongPhong varchar(10)

ALTER TABLE PhongBan
ADD CONSTRAINT FK_PhongBan_MaTruongPhong FOREIGN KEY (MaTruongPhong) REFERENCES NhanVien(MaNhanVien)

ALTER TABLE PhongBan
ADD CONSTRAINT UK_TenPhongBan UNIQUE(TenPhongBan)


ALTER TABLE NhanVien
ADD CONSTRAINT CK_GioiTinh CHECK(GioiTinh IN (N'Nam', N'Nữ'))


ALTER TABLE PhongBan
ADD NgayNhanChuc date DEFAULT GETDATE();

INSERT INTO PhongBan(TenPhongBan, MaTruongPhong)
	VALUES (N'IT', NULL)
INSERT INTO PhongBan(TenPhongBan, MaTruongPhong)
	VALUES (N'Kế Toán', NULL)
INSERT INTO PhongBan(TenPhongBan, MaTruongPhong)
	VALUES (N'Kinh doanh', NULL)

-- INSERT INTO PhongBan(TenPhongBan, MaTruongPhong) VALUES (N'Nhân sự', 'NV01')


INSERT INTO NhanVien(MaNhanVien, HoLot, Ten, NgaySinh, GioiTinh, DiaChi, Luong, MaPhongBan, MaNVQL)
	VALUES ('NV01', N'Đặng', N'Quang Minh', '2004-06-10', N'Nam', N'64 Thế Lữ', 2000.0, 1, null)

INSERT INTO NhanVien(MaNhanVien, HoLot, Ten, NgaySinh, GioiTinh, DiaChi, Luong, MaPhongBan, MaNVQL)
	VALUES ('NV02', N'Tran', N'Hoang Nam', '2004-11-14', N'Nam', N'12345 Ngô Quyền', 5000, 1, 'NV01')

INSERT INTO NhanVien(MaNhanVien, HoLot, Ten, NgaySinh, GioiTinh, DiaChi, Luong, MaPhongBan, MaNVQL)
	VALUES ('NV03', N'Châu', N'Tùng Đăng', '2004-11-14', N'Nam', NULL, 2000, 2, 'NV01')

INSERT INTO NhanVien(MaNhanVien, HoLot, Ten, NgaySinh, GioiTinh, DiaChi, Luong, MaPhongBan, MaNVQL)
	VALUES ('NV04', N'Nguyễn', N'Ngọc Diễm', '2004-1-15', N'Nữ', NULL, 3000, 2, 'NV01'),
	('NV05', N'Lê', N'Viết Hưng', '2000-11-14', N'Nam', NULL, 2000, 2, 'NV01'),
	('NV06', N'Nguyễn', N'Thùy Dương', '2004-11-14', N'Nữ', N'Đà nẵng', 1000, 3, 'NV02'),
	('NV07', N'Nguyễn', N'Kiều Linh', '2004-10-14', N'Nữ', N'Đà Nẵng', 2000, 2, 'NV01')

UPDATE NhanVien SET Luong =	Luong * 1.5 WHERE MaPhongBan = 1

DELETE FROM PhongBan
WHERE MaPhong = 1




Alter Table NhanVien
drop constraint FK_NhanVien_MaPhongBan

Alter Table NhanVien
add  CONSTRAINT FK_NhanVien_MaPhongBan FOREIGN KEY (MaPhongBan) REFERENCES PhongBan(MaPhong) on update cascade
																									on delete cascade

delete from PhongBan
where MaPhong=3

update NhanVien
set DiaChi = N'Đà Lạt'
where MaNhanVien ='NV03'


update PhongBan
set MaTruongPhong = 'NV03'
where MaPhong=1

select * from PhongBan
--4.Viết thủ tục lấy ra số lượng nhân viên của phòng ban nào đó
go
create proc sp_NhanVien_getSoLuongByMaPB
@maPB int,
@soLuong int OUT
AS
	Select @soLuong= count(MaNV)
	from NhanVien
	where MaPhongBan = @maPB
Select @soLuong AS 'Số lượng nhân viên'
--Chạy Tham số Output khác so với tham số in
DECLARE @kq int
EXEC sp_NhanVien_getSoLuongByMaPB @maPB = 4, @soLuong =@kq OUT


--Viết hàm đếm có bao nhiêu Nam/Nữ
Select count(Gender)
from student
where gender = 'Nam'

go
create function ufn_countGender(
@gender nvarchar(30)
)
returns int 
AS
Begin
	declare @numberGender int
	Select @numberGender= count(Gender)
	from student
	where gender = @gender
	return @numberGender
End
go

Select dbo.ufn_countGender(N'Nam') AS 'Số lượng'

--Viết hàm tính thành tiền
go
create function ufn_calculate(
@unitCost decimal,
@quantity int
)
returns decimal -- return này có s
AS
Begin
	declare @total decimal
	set @total = @unitCost * @quantity
	return @total --return này k có s
END
go
--gọi function
select dbo.ufn_calculate(1000,5) AS 'Thành tiền'

--Tạo 1 view chỉ cho hiển thị ID,Name của bảng subject
go
create view v_Subject
AS
	Select ID, Name
	from subject
go
select * from v_Subject

insert into v_Subject(Name)
values(N'PRO')

go
create view v_Subject_credit
AS
	Select ID, Name,credit
	from subject
	where credit>2
go
select * from subject
go
insert into v_Subject_credit(Name,credit)
values(N'PRO1',1)

--Yêu cầu trên view: 
--chỉ cho phép điều kiện credit >2
go
alter view v_Subject_credit
AS
	Select ID, Name,credit
	from subject
	where credit>2
with check option
go
insert into v_Subject_credit(Name,credit)
values(N'PRO1',1) -- không thể chèn với check option

insert into v_Subject_credit(Name,credit)
values(N'PRO3',3) -- chèn với check option


update v_Subject_credit
set credit = 1
where Id=11

