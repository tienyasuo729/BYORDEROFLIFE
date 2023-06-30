package com.tienthanh.serviceORM;

import com.tienthanh.modelORM.Android_PhoneORM;

import java.util.List;

public interface IAndroid_PhoneServiceORM {
    List<Android_PhoneORM> displayAndroid_Phone();
    Boolean add_or_edit_new_android_phone(Android_PhoneORM androidPhoneORM);
    Boolean check_if_id_exist(String idToCheck);
    Boolean delete_Android_Phone(String idToDelete);
    List<Android_PhoneORM> late_list_android_phone();
    List<Android_PhoneORM> near_term_list_android_phone();

}
