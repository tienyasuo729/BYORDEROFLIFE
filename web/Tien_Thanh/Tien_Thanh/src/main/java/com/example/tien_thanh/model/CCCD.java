package com.example.tien_thanh.model;

import java.util.Date;

public class CCCD {
    private String idCccd;
    private String name;
    private int price;
    private Date startDate;

    public CCCD(String idCccd, String name, int price, Date startDate) {
        this.idCccd = idCccd;
        this.name = name;
        this.price = price;
        this.startDate = startDate;
    }

    public String getIdCccd() {
        return idCccd;
    }

    public void setIdCccd(String idCccd) {
        this.idCccd = idCccd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
