package com.example.retake_module_3.Service;

import com.example.retake_module_3.model.Android_Phone;

import java.util.List;

public interface IAndroid_PhoneService {
    List<Android_Phone> list();
    Boolean add(Android_Phone y);
    Boolean edit(Android_Phone y);
    Boolean delete(int idNeedDelete);
    List<Android_Phone> findById(int idNeedFind);
    List<Android_Phone> findByName(int idNeedFind);
}
