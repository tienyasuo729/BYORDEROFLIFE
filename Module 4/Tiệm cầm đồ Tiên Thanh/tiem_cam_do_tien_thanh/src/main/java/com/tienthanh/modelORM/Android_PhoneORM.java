package com.tienthanh.modelORM;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Entity
@Table(name = "android_phone")
public class Android_PhoneORM {
    @Id
//    @Column(name = "student_id") // dòng này để Đặt tên cột là "tên bạn muốn đặt" cho table trong sql mà không phải lấy tên của thuộc tính
    private String id;
    private String name_owner;
    private String name_phone;
    private String id_of_phone;
    private int price;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date start_Date;
    private String phone_number_owner;
    private String status;
    private String password;
    private String note;

    public Android_PhoneORM() {

    }

    public Android_PhoneORM(String id, String name_owner, String name_phone, String id_of_phone, int price, Date start_Date, String phone_number_owner, String status, String password, String note) {
        this.id = id;
        this.name_owner = name_owner;
        this.name_phone = name_phone;
        this.id_of_phone = id_of_phone;
        this.price = price;
        this.start_Date = start_Date;
        this.phone_number_owner = phone_number_owner;
        this.status = status;
        this.password = password;
        this.note = note;
    }


    public String getPhone_number_owner() {
        return phone_number_owner;
    }

    public void setPhone_number_owner(String phone_number_owner) {
        if (phone_number_owner.isEmpty()) {
            this.phone_number_owner = "Không có";
        } else {
            this.phone_number_owner = phone_number_owner;
        }    }

    public String getId_of_phone() {
        return id_of_phone;
    }

    public void setId_of_phone(String id_of_phone) {
        this.id_of_phone = id_of_phone;
    }

    public String getName_phone() {
        return name_phone;
    }

    public void setName_phone(String name_phone) {
        this.name_phone = name_phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName_owner() {
        return name_owner;
    }

    public void setName_owner(String name_owner) {
        this.name_owner = name_owner;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getStart_Date() {
        return start_Date;
    }

    public void setStart_Date(Date start_Date) {
        if (start_Date == null){
            this.start_Date = new Date();
        }else {
            this.start_Date = start_Date;
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (status.isEmpty()) {
            this.status = "Bình thường";
        } else {
            this.status = status;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password.isEmpty()) {
            this.password = "Không có";
        } else {
            this.password = password;
        }
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        if (note.isEmpty()) {
            this.note = "Không có";
        } else {
            this.note = note;
        }
    }
    @Override
    public String toString() {
        return "Android_Phone{" +
                "id='" + id + '\'' +
                ", name_owner='" + name_owner + '\'' +
                ", name_phone='" + name_phone + '\'' +
                ", id_of_phone='" + id_of_phone + '\'' +
                ", price=" + price +
                ", start_Date=" + start_Date +
                ", phone_number_owner='" + phone_number_owner + '\'' +
                ", status='" + status + '\'' +
                ", password='" + password + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
