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
//    private static final String LIST_PRODUCT = "select * from product;";
//    private static final String ADD_NEW_PRODUCT = "INSERT INTO product(id,name, price, quantity, color, description, idcategory ) VALUES (?, ?, ?, ?, ?, ?, ?);";
//
//    private static final String DELETE_PRODUCT = "DELETE FROM PRODUCT WHERE id = ?;";
//
//    private static final String EDIT_PRODUCT = "UPDATE product SET name = ?, price = ?, quantity = ?, color = ?, description = ?, idcategory = ? WHERE id = ?;";
//
//    private static final String FIND_BY_NAME = "SELECT * FROM product WHERE name LIKE ?";
//
//    private static final String FIND_BY_ID = "SELECT * FROM product WHERE id = ?";
    private String DISPLAY_ANDROID_PHONE = "select * from android_phone";
    private String ADD_NEW_ANDROID_PHONE = "INSERT INTO android_phone(id,name_owner, name_phone, price, start_Date, status, password, note ) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    private String DELETE_ANDROID_PHONE_BY_ID = "delete from android_phone where id = ?";
    private String EDIT_ANDROID_PHONE_BY_ID = "UPDATE android_phone SET name_owner = ?,name_phone = ?,price = ?,start_Date = ?,status = ?,password = ?,note = ? WHERE id = ?";
    private String INTEREST_PAYMENT = "UPDATE android_phone SET  start_Date = ? WHERE id = ?";
    @Override
    public void interest_payment(String id, Date date) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(INTEREST_PAYMENT);
            preparedStatement.setDate(1, new java.sql.Date(date.getTime()));
            preparedStatement.setString(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

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
    public void edit_Android_Phone(Android_Phone android_phone) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(EDIT_ANDROID_PHONE_BY_ID);
            preparedStatement.setString(1,android_phone.getName_owner());
            preparedStatement.setString(2,android_phone.getName_phone());
            preparedStatement.setInt(3,android_phone.getPrice());
            preparedStatement.setDate(4,new java.sql.Date(android_phone.getStart_Date().getTime()));
            preparedStatement.setString(5,android_phone.getStatus());
            preparedStatement.setString(6,android_phone.getPassword());
            preparedStatement.setString(7,android_phone.getNote());
            preparedStatement.setString(8,android_phone.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete_Android_Phone(String id) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(DELETE_ANDROID_PHONE_BY_ID);
            preparedStatement.setString(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Android_Phone find_Android_Phone_By_id(String id) {
        return null;
    }

    @Override
    public List<Android_Phone> list_Find_Android_Phone_Similar_By_Id(String id) {
        return null;
    }

    @Override
    public Android_Phone find_Android_Phone_By_Name(String id) {
        return null;
    }

    @Override
    public List<Android_Phone> list_Find_Android_Phone_Similar_By_Name(String id) {
        return null;
    }
}
