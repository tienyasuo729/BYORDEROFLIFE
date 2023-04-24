package com.example.tien_thanh.model;

import java.util.Date;

public class CCCD{
    private String cccd;
    private String name;
    private int price;
    private Date startDate;
    private int checkForDetail;

    public CCCD(String cccd, String name, int price, Date startDate) {
        this.cccd = cccd;
        this.name = name;
        this.price = price;
        this.startDate = startDate;
    }

    public CCCD(String cccd, String name, int price, Date startDate, int checkForDetail) {
        this.cccd = cccd;
        this.name = name;
        this.price = price;
        this.startDate = startDate;
        this.checkForDetail = checkForDetail;
    }

    public int getCheckForDetail() {
        return checkForDetail;
    }

    public void setCheckForDetail(int checkForDetail) {
        this.checkForDetail = checkForDetail;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
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