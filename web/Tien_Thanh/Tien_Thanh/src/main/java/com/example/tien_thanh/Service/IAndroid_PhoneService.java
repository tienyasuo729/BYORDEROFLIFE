package com.example.tien_thanh.Service;

import com.example.tien_thanh.model.Android_Phone;
import com.example.tien_thanh.model.CCCD;

import java.util.List;

public interface IAndroid_PhoneService {
    List<Android_Phone> displayAndroid_Phone();
    void add_New_Android_Phone(Android_Phone android_phone);
    void editAndroid_Phone(Android_Phone android_phone);
    void deleteAndroid_Phone(String id);
    CCCD findAndroid_PhoneByid(String id);
    List<CCCD> listFindAndroid_PhoneSimilarById(String id);
    CCCD findAndroid_PhoneByName(String id);
    List<CCCD> listFindAndroid_PhoneSimilarByName(String id);
}
