package com.example.quan_ly_sann_pham.repository;

import com.example.quan_ly_sann_pham.model.Product;

import java.util.List;

public interface IProductRepository {
    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(int id);
    List<Product> listProduct();
//    List<Employee> findByNameOfJob();
//    List<Employee> findByStartDateOfJob();
//    List<Employee> findByEndDateOfJob();

}
