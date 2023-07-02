package model;

import java.util.Date;

public class PhoneAndLaptopAndVehicle extends Customer{
    private String manufacturer;
    private String nameDevice;
    private String passwordOrLicensePlate;
    private String status;

    public PhoneAndLaptopAndVehicle(int id, String name, String cccd, int price, String phoneNumber, Date pawnDate, String note, String manufacturer, String nameDevice, String passwordOrLicensePlate, String status) {
        super(id, name, cccd, price, phoneNumber, pawnDate, note);
        if (nameDevice.replaceAll("\\s+", "").isEmpty()){
            nameDevice = "Không có";
        }
        if (passwordOrLicensePlate.replaceAll("\\s+", "").isEmpty()){
            passwordOrLicensePlate = "Không có";
        }
        if (status.replaceAll("\\s+", "").isEmpty()){
            status = "Bình thường";
        }
        this.manufacturer = manufacturer;
        this.nameDevice = nameDevice;
        this.passwordOrLicensePlate = passwordOrLicensePlate;
        this.status = status;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getNameDevice() {
        return nameDevice;
    }

    public void setNameDevice(String nameDevice) {
        this.nameDevice = nameDevice;
    }

    public String getPasswordOrLicensePlate() {
        return passwordOrLicensePlate;
    }

    public void setPasswordOrLicensePlate(String passwordOrLicensePlate) {
        this.passwordOrLicensePlate = passwordOrLicensePlate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String toStringPhoneOrLaptop() {
        return getId() +
                " . Tên: " + getName() +
                " | CCCD: " + getCccd() +
                " | Số tiền cầm: " + getPrice() +
                " | Hãng: " + manufacturer +
                " | Tên máy: " + nameDevice +
                " | Ngày cầm: " + getPawnDate() +
                " | SĐT: " + getPhoneNumber() +
                " | Mật khẩu: " + passwordOrLicensePlate +
                " | Tình trạng: " + status +
                " | Ghi chú: " + getNote();
    }
    public String toStringVehicle() {
        return getId() +
                " . Tên chủ xe: " + getName() +
                " | CCCD: " + getCccd() +
                " | Số tiền cầm: " + getPrice() +
                " | Hãng xe: " + manufacturer +
                " | Tên xe: " + nameDevice +
                " | Ngày cầm: " + getPawnDate() +
                " | SĐT: " + getPhoneNumber() +
                " | Biển số xe: " + passwordOrLicensePlate +
                " | Tình trạng xe: " + status +
                " | Ghi chú: " + getNote();
    }
}
