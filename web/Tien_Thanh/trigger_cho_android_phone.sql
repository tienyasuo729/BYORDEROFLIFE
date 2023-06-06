-- này là trigger để lưu lại lịch sử thay đổi sau khi chúng ta chỉnh sửa
DELIMITER //

CREATE TRIGGER history_for_update
AFTER UPDATE ON android_phone
FOR EACH ROW
BEGIN
    IF New.id != OLD.id 
    OR New.name_owner != OLD.name_owner 
    OR New.name_phone != OLD.name_phone 
    OR New.id_of_phone != OLD.id_of_phone 
    OR NEW.price != OLD.price 
    OR NEW.start_Date != OLD.start_Date 
    OR NEW.phone_number_owner != OLD.phone_number_owner 
    OR NEW.status != OLD.status
    OR NEW.password != OLD.password
    OR NEW.note != OLD.note THEN
    
        INSERT INTO LichSuThayDoi (Action, DuLieuCu, DuLieuMoi)
        VALUES ('UPDATE', 
        JSON_OBJECT(
        'id', OLD.id,
        'name_owner', OLD.name_owner,
        'name_phone', OLD.name_phone ,
        'id_of_phone', OLD.id_of_phone,
        'price', OLD.price,
        'start_Date', OLD.start_Date,
        'phone_number_owner', OLD.phone_number_owner,
        'status', OLD.status,
        'password', OLD.password,
        'note', OLD.note
			),
		
        JSON_OBJECT(
        'id', NEW.id,
        'name_owner', NEW.name_owner,
        'name_phone', NEW.name_phone ,
        'id_of_phone', NEW.id_of_phone,
        'price', NEW.price,
        'start_Date', NEW.start_Date,
        'phone_number_owner', NEW.phone_number_owner,
        'status', NEW.status,
        'password', NEW.password,
        'note', NEW.note
			)
		);
    END IF;
END //

DELIMITER ;


-- này là trigger lưu lại lịch sử khi chúng ta thêm dữ liệu mới vào
DELIMITER //

CREATE TRIGGER android_phone_after_insert
AFTER INSERT ON android_phone
FOR EACH ROW
BEGIN
    INSERT INTO LichSuThayDoi (Action, DuLieuMoi)
    VALUES ('INSERT', JSON_OBJECT('price', NEW.price, 'status', NEW.status, 'note', NEW.note));
END //

DELIMITER ;

-- này là trigger lưu lại lịch sử khi chúng ta xoá một dữ liệu nào đó
DELIMITER //

CREATE TRIGGER android_phone_after_delete
AFTER DELETE ON android_phone
FOR EACH ROW
BEGIN
    INSERT INTO LichSuThayDoi (Action, DuLieuCu)
    VALUES ('DELETE', JSON_OBJECT('price', OLD.price, 'status', OLD.status, 'note', OLD.note));
END //

DELIMITER ;

-- đây là trigger tổng hợp của cả 3 trigger trên (bị lỗi rồi nên không thể viết cả 3 sự kiện vào 1 trigger)
DELIMITER //

CREATE TRIGGER android_phone_history_trigger
AFTER INSERT, UPDATE, DELETE ON android_phone
FOR EACH ROW
BEGIN
    DECLARE action VARCHAR(10);
    DECLARE data_old JSON;
    DECLARE data_new JSON;

    IF (INSERTING) THEN
        SET action = 'INSERT';
        SET data_new = JSON_OBJECT('price', NEW.price, 'status', NEW.status, 'note', NEW.note);
    ELSEIF (UPDATING) THEN
        SET action = 'UPDATE';
        SET data_old = JSON_OBJECT('price', OLD.price, 'status', OLD.status, 'note', OLD.note);
        SET data_new = JSON_OBJECT('price', NEW.price, 'status', NEW.status, 'note', NEW.note);
    ELSEIF (DELETING) THEN
        SET action = 'DELETE';
        SET data_old = JSON_OBJECT('price', OLD.price, 'status', OLD.status, 'note', OLD.note);
    END IF;

    INSERT INTO LichSuThayDoi (Action, DuLieuCu, DuLieuMoi)
    VALUES (action, data_old, data_new);
END //

DELIMITER ;


drop trigger android_phone_after_update;
