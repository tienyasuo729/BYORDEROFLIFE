create database PE_FA23
use PE_FA23

create table Student(
ID int identity (1,1) primary key,
FirstName nvarchar(30) not null,
LastName nvarchar(30) not null,
Gender nvarchar(50) check (Gender in (N'Nam',N'Nữ')), -- check có tác kiểm tra 1 trong 2 mới hợp lệ
Birthdate date,
IdClass int,
foreign key (IdClass) references class(ID)
)

create table Subject(
ID int identity(1,1) primary key,
Name nvarchar(30) not null,
Description nvarchar(50),
credit smallint
)

create table Enrollment(
IdStudent int not null,
IdSubject int not null,
Grade varchar(1) check (Grade in ('A','B','C','D','F')),
constraint pk_enrollment primary key(IdStudent, IdSubject),
constraint fk_enrollment_Student foreign key(IdStudent) references Student(Id),
constraint fk_enrollment_Subject foreign key(idSubject) references Subject(Id)
)

Create table SubjectPrerequisite(
IdSubject int not null,
IdPrerequisite int not null,
constraint pk_SubjectPrerequisite Primary key(IdSubject,IdPrerequisite),
constraint  fk_SubjectPrerequisite Foreign key(IdPrerequisite) references Subject(ID),
constraint  fk_SubjectPrerequisite2 Foreign key(IdPrerequisite) references Subject(ID)
)


--Code for insert values to all table
insert into Student(FirstName,LastName,BirthDate,Gender)
values(N'Lê',N'Nhất Huy','2000-02-20', N'Nam'),
(N'Nguyễn',N'Thu Thủy','2002-10-21', N'Nữ'),
(N'Trần Thị',N'Thanh Nhàn','2004-10-22', N'Nữ'),
(N'Lê Nguyễn',N'Hoài Nhân','2003-02-02', N'Nam'),
(N'Trần Thanh',N'Thủy','2004-01-01', N'Nữ')


insert into Subject(Name, Description,credit)
values(N'PRN211', N'Lập trình C#',3),
(N'DBI202', N'Cơ sở dữ liệu',3),
(N'SWR301', N'Kỹ thuật phần mềm',2),
(N'PRF192', N'Lập trình cơ bản C',2),
(N'SWT301', N'Kiểm thử phần mềm',2)

insert into Enrollment(IdStudent,IdSubject,grade)
values(1,1,'A'),
(1,2,'B'),
(2,1,'C'),
(2,3,'D'),
(3,4,'A'),
(3,1,'A'),
(3,2,'A'),
(4,1,'F'),
(4,2,'D')

insert into SubjectPrerequisite
values(1,2),
(3,2),
(3,4),
(5,2),
(5,1)

create table class(
	id int identity(1,1) primary key,
	name nvarchar(30) unique not null,
	schoolyear int,
	NumberOfStudents int check (NumberOfStudents > 0)
)

-- Insert records into the Class table
insert into Class (Name, SchoolYear, NumberOfStudents)
values
    (N'Class A', 2023, 25),
    (N'Class B', 2023, 30),
    (N'Class C', 2023, 28),
    (N'Class D', 2023, 32),
    (N'Class E', 2023, 27)

select id, FirstName + ' ' + LastName as [full name], datediff(year, Birthdate, GETDATE()) as [Age] from student
order by age asc, ID desc