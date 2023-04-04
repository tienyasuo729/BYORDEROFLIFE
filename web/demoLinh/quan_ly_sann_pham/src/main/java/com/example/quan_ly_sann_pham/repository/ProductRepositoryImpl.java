package com.example.quan_ly_sann_pham.repository;

import com.example.quan_ly_sann_pham.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class ProductRepositoryImpl implements IProductRepository{
    private BaseRepository baseRepository = new BaseRepository();
    private static final String LIST_PRODUCT = "select * from product";
    private static final String ADD_NEW_PRODUCT = "INSERT INTO product(name, price, quantity, color, description, category ) VALUES (?, ?, ?, ?, ?, ?)";

    @Override
    public void addProduct(Product product) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(ADD_NEW_PRODUCT);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getDescription());
            preparedStatement.setString(6, product.getCategory());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateProduct(Product product) {

    }

    @Override
    public List<Product> listProduct() {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(LIST_PRODUCT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("stt");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                String description = resultSet.getString("description");
                String category = resultSet.getString("category");
                products.add(new Product(id,name,price,quantity,color,description,category));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public void deleteProduct(int id) {

    }
}
