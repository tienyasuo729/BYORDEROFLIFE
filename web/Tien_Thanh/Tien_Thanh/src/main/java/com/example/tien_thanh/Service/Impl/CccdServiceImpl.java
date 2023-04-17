package com.example.tien_thanh.Service.Impl;

import com.example.tien_thanh.Repository.ICccdRepository;
import com.example.tien_thanh.Repository.Impl.CccdRepositoryImpl;
import com.example.tien_thanh.Service.ICccdService;
import com.example.tien_thanh.model.CCCD;

import java.util.List;

public class CccdServiceImpl implements ICccdService {
    private ICccdRepository cccdRepository = new CccdRepositoryImpl();

    @Override
    public List<CCCD> displayCCCD() {
        return cccdRepository.displayCCCD();
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
