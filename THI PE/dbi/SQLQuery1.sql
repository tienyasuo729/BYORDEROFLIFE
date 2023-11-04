--Tạo trigger in ra thông báo chỉ cho phép chèn tin chi >=2
create trigger trg_SubjectAddByCredit
ON Subject
For insert
AS
 --cần lấy credit của dòng chuẩn bị được thêm vào
 declare @credit int
 Select @credit = credit from inserted
 IF @credit <2
  --Không được phép chèn
  Begin
   Raiserror(N'Lỗi yêu cầu số tín chỉ >=2', 16,1)
   rollback transaction --hủy thêm vào
  End
 else
 Begin
  --cần lấy ID, Name của dữ liệu chuẩn bị thêm vào
  declare @id int
  declare @name nvarchar(30)
  SET @id = (select id from inserted)
  SELECT @name = Name from inserted --ngắn gọn
  
  print N'Đã chèn '+ CAST(@id AS varchar) +' ,'+@name+ ' thành công!'
 End
 
 
  
Insert into Subject(Name, Credit)
values(N'Lenin',1)

Insert into Subject(Name, Credit)
values(N'Lenin',3)


--Tạo trigger in ra thông báo chỉ cho phép chèn tin chi >=2
create trigger trg_SubjectAddByCredit
ON Subject
For insert
AS
 --cần lấy credit của dòng chuẩn bị được thêm vào
 declare @credit int
 Select @credit = credit from inserted
 IF @credit <2
  --Không được phép chèn
  Begin
   Raiserror(N'Lỗi yêu cầu số tín chỉ >=2', 16,1)
   rollback transaction --hủy thêm vào
  End
 else
 Begin
  --cần lấy ID, Name của dữ liệu chuẩn bị thêm vào
  declare @id int
  declare @name nvarchar(30)
  SET @id = (select id from inserted)
  SELECT @name = Name from inserted --ngắn gọn
  
  print N'Đã chèn '+ CAST(@id AS varchar) +' ,'+@name+ ' thành công!'
 End
 
 
  
Insert into Subject(Name, Credit)
values(N'Lenin',1)

Insert into Subject(Name, Credit)
values(N'Lenin',3)