package com.example.quanlysanpham.service;

import com.example.quanlysanpham.bean.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService{
    private ProductService productService = new ProductServiceImpl();
    @Override
    public List display() {
        List<Product> productList = this.productService.display();
        return productList;
    }

    @Override
    public void create(Product product) {

    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Product findById(String id) {
        return null;
    }

    @Override
    public Product findByName(String name) {
        return null;
    }
}
