package com.example.tien_thanh.Repository.Impl;

import com.example.tien_thanh.Connections.BaseRepository;
import com.example.tien_thanh.Repository.Android_PhoneRepository;
import com.example.tien_thanh.model.Android_Phone;
import com.example.tien_thanh.model.CCCD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Android_PhoneRepositoryImpl implements Android_PhoneRepository {
    private BaseRepository baseRepository = new BaseRepository();
    private String DISPLAY_ANDROID_PHONE = "select * from android_phone";
    private String ADD_NEW_ANDROID_PHONE = "INSERT INTO android_phone(id,name_owner, name_phone, price, start_Date, status, password, note ) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    @Override
    public List<Android_Phone> displayAndroid_Phone() {
        List<Android_Phone> androidPhoneList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(DISPLAY_ANDROID_PHONE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String id = resultSet.getString("id");
                String name_owner = resultSet.getString("name_owner");
                String name_phone = resultSet.getString("name_phone");
                int price = resultSet.getInt("price");
                Date start_Date  = new Date(resultSet.getDate("start_Date").getTime());
                String status = resultSet.getString("status");
                String password = resultSet.getString("password");
                String note = resultSet.getString("note");
                androidPhoneList.add(new Android_Phone(id,name_owner,name_phone,price,start_Date,status,password,note));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return androidPhoneList;
    }

    @Override
    public void add_New_Android_Phone(Android_Phone android_phone) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(ADD_NEW_ANDROID_PHONE);
            preparedStatement.setString(1, android_phone.getId());
            preparedStatement.setString(2, android_phone.getName_owner());
            preparedStatement.setString(3, android_phone.getName_phone());
            preparedStatement.setInt(4, android_phone.getPrice());
            preparedStatement.setDate(5, new java.sql.Date(android_phone.getStart_Date().getTime()));
            preparedStatement.setString(6, android_phone.getStatus());
            preparedStatement.setString(7, android_phone.getPassword());
            preparedStatement.setString(8, android_phone.getNote());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void editAndroid_Phone(Android_Phone android_phone) {

    }

    @Override
    public void deleteAndroid_Phone(String id) {

    }

    @Override
    public CCCD findAndroid_PhoneByid(String id) {
        return null;
    }

    @Override
    public List<CCCD> listFindAndroid_PhoneSimilarById(String id) {
        return null;
    }

    @Override
    public CCCD findAndroid_PhoneByName(String id) {
        return null;
    }

    @Override
    public List<CCCD> listFindAndroid_PhoneSimilarByName(String id) {
        return null;
    }
}
