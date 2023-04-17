package com.example.tien_thanh.Service.Impl;

import com.example.tien_thanh.Repository.IDetailRepository;
import com.example.tien_thanh.Repository.Impl.DetailRepositoryImpl;
import com.example.tien_thanh.Service.IDetailService;
import com.example.tien_thanh.model.Detail;

import java.util.List;

public class DetailServiceImpl implements IDetailService {
    private IDetailRepository detailRepository = new DetailRepositoryImpl();

    @Override
    public List<Detail> displayDetail() {
        return detailRepository.displayDetail();
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
