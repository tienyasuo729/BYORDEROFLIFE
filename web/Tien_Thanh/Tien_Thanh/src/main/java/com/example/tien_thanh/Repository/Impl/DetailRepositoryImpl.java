package com.example.tien_thanh.Repository.Impl;

import com.example.tien_thanh.Connections.BaseRepository;
import com.example.tien_thanh.Repository.IDetailRepository;
import com.example.tien_thanh.model.Detail;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DetailRepositoryImpl implements IDetailRepository {
    private BaseRepository baseRepository = new BaseRepository();

    private static String displayDetail = "select * from detail";

    @Override
    public List<Detail> displayDetail() {
        List<Detail> detailList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(displayDetail);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String idDetail = resultSet.getString("idDetail");
                String nameDetail = resultSet.getString("name");
                Date birthday = new Date(resultSet.getDate("birthday").getTime());
                String gender = resultSet.getString("gender");
                String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("phoneNumber");
                int times = resultSet.getInt("times");
                String history = resultSet.getString("history");
                detailList.add(new Detail(idDetail,nameDetail,birthday,gender,address,phoneNumber,times,history));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return detailList;
    }

    @Override
    public void addNewDetail(Detail detail) {

    }

    @Override
    public void editDetail(Detail detail) {

    }

    @Override
    public void deleteDetail(String id) {

    }

    @Override
    public Detail finDetailByid(String id) {
        return null;
    }

    @Override
    public List listFinDetailSimilarById(String id) {
        return null;
    }

    @Override
    public Detail finDetailByName(String id) {
        return null;
    }

    @Override
    public List listFinDetailSimilarByName(String id) {
        return null;
    }
}
