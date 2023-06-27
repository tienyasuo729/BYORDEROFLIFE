package com.tienthanh.repositoryORM;

import com.tienthanh.modelORM.Android_PhoneORM;

import java.util.List;

public interface IAndroid_PhoneRepositoryORM {
    List<Android_PhoneORM> displayAndroid_Phone();
    Boolean add_new_android_phone(Android_PhoneORM androidPhoneORM);
    Boolean check_if_id_exist(String idToCheck);
    Boolean delete_Android_Phone(String idToDelete);

}
