package com.example.tien_thanh.Service;

import com.example.tien_thanh.model.Android_Phone;

import java.util.List;

public interface IAndroid_PhoneService {
    List<Android_Phone> displayAndroid_Phone();
    void add_New_Android_Phone(Android_Phone android_phone);
    void edit_Android_Phone(Android_Phone android_phone);
    void delete_Android_Phone(String id);
    Android_Phone find_Android_Phone_By_id(String id);
    List<Android_Phone> list_Find_Android_Phone_Similar_By_Id(String id);
    Android_Phone find_Android_Phone_By_Name(String id);
    List<Android_Phone> list_Find_Android_Phone_Similar_By_Name(String id);
}
