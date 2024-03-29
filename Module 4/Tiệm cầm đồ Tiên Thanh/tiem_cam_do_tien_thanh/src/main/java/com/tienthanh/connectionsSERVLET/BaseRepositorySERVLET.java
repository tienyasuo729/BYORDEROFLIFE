package com.tienthanh.connectionsSERVLET;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepositorySERVLET {
    private String jdbcUrl = "jdbc:mysql://localhost:3306/tien_thanh";
    private String username = "root";
    private String password = "12345";
    private Connection connection;

    public BaseRepositorySERVLET() {

    }

    public Connection getConnectionJavaToDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(jdbcUrl, username, password);
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
