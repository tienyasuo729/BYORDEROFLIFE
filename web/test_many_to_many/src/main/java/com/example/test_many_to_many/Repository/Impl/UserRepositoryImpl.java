package com.example.test_many_to_many.Repository.Impl;

import com.example.test_many_to_many.Connections.BaseRepository;
import com.example.test_many_to_many.Repository.IUserRepository;
import com.example.test_many_to_many.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserRepositoryImpl implements IUserRepository {
    private BaseRepository baseRepository= new BaseRepository();
    private String DISPLAY_LIST_USER = "";
    @Override
    public List<User> display_list_user() {
        List<User> userList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(DISPLAY_LIST_USER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("idUser");
                String fullName = resultSet.getString("fullName");
                String code = resultSet.getString("code");
                Date birthdate = new Date(resultSet.getDate("birthdate").getTime());
                Date timeBuild = new Date(resultSet.getDate("timeBuild").getTime());
                userList.add(new User(id,fullName,code,birthdate,timeBuild));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }
}
