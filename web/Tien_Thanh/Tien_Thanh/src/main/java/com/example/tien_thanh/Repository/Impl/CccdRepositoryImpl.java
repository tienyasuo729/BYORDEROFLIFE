package com.example.tien_thanh.Repository.Impl;

import com.example.tien_thanh.Connections.BaseRepository;
import com.example.tien_thanh.Repository.ICccdRepository;
import com.example.tien_thanh.model.CCCD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CccdRepositoryImpl implements ICccdRepository {
    private BaseRepository baseRepository = new BaseRepository();
    private static String displayCCCD = "select * from cccd";

    @Override
    public List<CCCD> displayCCCD() {
        List<CCCD> cccdList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(displayCCCD);
            ResultSet resultSet =  preparedStatement.executeQuery();
            while (resultSet.next()){
                String cccd = resultSet.getString("cccd");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                Date startDate = new Date(resultSet.getDate("startDate").getTime());
                int checkForDetail = resultSet.getInt("checkForDetail");
//                cccdList.add(new CCCD(cccd,name,price,startDate));
                cccdList.add(new CCCD(cccd,name,price,startDate,checkForDetail));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cccdList;
    }

    @Override
    public void addNewCCCD(CCCD cccd) {

    }

    @Override
    public void editCCCD(CCCD cccd) {

    }

    @Override
    public void deleteCCCD(String id) {

    }

    @Override
    public CCCD findCccdByid(String id) {
        return null;
    }

    @Override
    public List<CCCD> listFindCccdSimilarById(String id) {
        return null;
    }

    @Override
    public CCCD findCccdByName(String id) {
        return null;
    }

    @Override
    public List<CCCD> listFindCccdSimilarByName(String id) {
        return null;
    }
}
