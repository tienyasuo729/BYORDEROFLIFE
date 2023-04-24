package com.example.tien_thanh.Service.Impl;

import com.example.tien_thanh.Repository.Android_PhoneRepository;
import com.example.tien_thanh.Repository.Impl.Android_PhoneRepositoryImpl;
import com.example.tien_thanh.Service.IAndroid_PhoneService;
import com.example.tien_thanh.model.Android_Phone;
import com.example.tien_thanh.model.CCCD;

import java.util.List;

public class Android_PhoneServiceImpl implements IAndroid_PhoneService {
    private Android_PhoneRepository android_phoneRepository = new Android_PhoneRepositoryImpl();
    @Override
    public List<Android_Phone> displayAndroid_Phone() {
        return android_phoneRepository.displayAndroid_Phone();
    }

    @Override
    public void add_New_Android_Phone(Android_Phone android_phone) {
        android_phoneRepository.add_New_Android_Phone(android_phone);
    }

    @Override
    public void editAndroid_Phone(Android_Phone android_phone) {

    }

    @Override
    public void deleteAndroid_Phone(String id) {

    }

    @Override
    public CCCD findAndroid_PhoneByid(String id) {
        return null;
    }

    @Override
    public List<CCCD> listFindAndroid_PhoneSimilarById(String id) {
        return null;
    }

    @Override
    public CCCD findAndroid_PhoneByName(String id) {
        return null;
    }

    @Override
    public List<CCCD> listFindAndroid_PhoneSimilarByName(String id) {
        return null;
    }
}
