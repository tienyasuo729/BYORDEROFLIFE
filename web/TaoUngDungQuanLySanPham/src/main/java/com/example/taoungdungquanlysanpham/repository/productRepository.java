package com.example.taoungdungquanlysanpham.repository;

import com.example.taoungdungquanlysanpham.bean.Product;

public interface productRepository {
    void create(Product product);
    void delete(String id);
    void update(Product product);
    Product findByName(Product product);
    Product detail(Product product);
}
