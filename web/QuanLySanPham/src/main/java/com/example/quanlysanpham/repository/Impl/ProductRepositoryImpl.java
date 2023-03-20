package com.example.quanlysanpham.repository.Impl;

import com.example.quanlysanpham.bean.Product;
import com.example.quanlysanpham.repository.ProductRepository;

import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {
    private Repository repository = new Repository();
    @Override
    public List display() {
        return null;
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
