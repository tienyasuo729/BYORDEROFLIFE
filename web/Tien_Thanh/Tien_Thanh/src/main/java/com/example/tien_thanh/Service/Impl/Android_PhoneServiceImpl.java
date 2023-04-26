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
    public void edit_Android_Phone(Android_Phone android_phone) {
        android_phoneRepository.edit_Android_Phone(android_phone);
    }

    @Override
    public void delete_Android_Phone(String id) {
        android_phoneRepository.delete_Android_Phone(id);
    }

    @Override
    public Android_Phone find_Android_Phone_By_id(String id) {
        return null;
    }

    @Override
    public List<Android_Phone> list_Find_Android_Phone_Similar_By_Id(String id) {
        return null;
    }

    @Override
    public Android_Phone find_Android_Phone_By_Name(String id) {
        return null;
    }

    @Override
    public List<Android_Phone> list_Find_Android_Phone_Similar_By_Name(String id) {
        return null;
    }
}
