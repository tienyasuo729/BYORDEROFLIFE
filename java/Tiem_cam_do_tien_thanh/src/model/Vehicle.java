package model;

import java.util.Date;

public class Vehicle extends Customer{
   private String manufacturerVehicle;
   private String nameVehicle;
   private String licensePlate;
   private String statusVehicle;

    public Vehicle(int id, String name, String cccd, int price, String phoneNumber, Date pawnDate, String note, String manufacturerVehicle, String nameVehicle, String licensePlate, String statusVehicle) {
        super(id, name, cccd, price, phoneNumber, pawnDate, note);
        this.manufacturerVehicle = manufacturerVehicle;
        this.nameVehicle = nameVehicle;
        this.licensePlate = licensePlate;
        this.statusVehicle = statusVehicle;
    }
}
