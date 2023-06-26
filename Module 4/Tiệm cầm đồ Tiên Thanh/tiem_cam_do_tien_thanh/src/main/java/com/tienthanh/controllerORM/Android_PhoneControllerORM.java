package com.tienthanh.controllerORM;

import com.tienthanh.modelJDBC.Android_PhoneJDBC;
import com.tienthanh.modelORM.Android_PhoneORM;
import com.tienthanh.serviceORM.IAndroid_PhoneServiceORM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("tienthanhORM")
public class Android_PhoneControllerORM {
    @Autowired
    private IAndroid_PhoneServiceORM androidPhoneServiceORM;
    @GetMapping("")
    public String listAndroid_Phone(Model model){
        model.addAttribute("listAndroid_Phone", androidPhoneServiceORM.displayAndroid_Phone());
        model.addAttribute("android_phone", new Android_PhoneORM());
        return "listAndroid_Phone";
    }
    @PostMapping("save_create_android_phone")
    public String save_create_android_phone(@ModelAttribute Android_PhoneORM androidPhoneORM){
        System.out.println(androidPhoneServiceORM.add_new_android_phone(androidPhoneORM));
        return "listAndroid_Phone";
    }
}
