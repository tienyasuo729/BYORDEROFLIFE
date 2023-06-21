package com.tienthanh.controller;

import com.tienthanh.model.Android_Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
//@RequestMapping(value = "/tienthanh", method = RequestMethod.GET)
@RequestMapping("/tienthanh")
public class Android_PhoneController {
    @GetMapping("")
    public String listAndroid_Phone(Model model) {
        List<Android_Phone> androidPhones = new ArrayList<>();
        androidPhones.add(new Android_Phone("1","1","1","1",1,new Date(),"1","1","1","1"));
        androidPhones.add(new Android_Phone("2","2","2","2",2,new Date(),"2","2","2","2"));
        model.addAttribute("listAndroid_Phone", androidPhones);
        model.addAttribute("android_phone", new Android_Phone());

//        ModelAndView modelAndView = new ModelAndView("listAndroid_Phone");
//        modelAndView.addObject("listAndroid_Phone", android_phoneService.displayAndroid_Phone());
//        modelAndView.addObject("Android_phone", new Android_Phone());
//        return modelAndView;
        return "listAndroid_Phone";
    }

    @PostMapping("save_create_android_phone")
        public String aaaa(@ModelAttribute Android_Phone android_phone){
        System.out.println(android_phone.toString());
        System.out.println("kkkkkkkkkkkk");
        return "listAndroid_Phone";
    }
}
