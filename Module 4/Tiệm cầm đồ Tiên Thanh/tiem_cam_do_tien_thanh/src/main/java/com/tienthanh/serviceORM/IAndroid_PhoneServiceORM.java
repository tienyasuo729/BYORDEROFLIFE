package com.tienthanh.serviceORM;

import com.tienthanh.modelORM.Android_PhoneORM;

import java.util.List;

public interface IAndroid_PhoneServiceORM {
    List<Android_PhoneORM> displayAndroid_Phone();
    Boolean add_new_android_phone(Android_PhoneORM androidPhoneORM);

}
