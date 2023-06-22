package com.tienthanh.controller;

import com.tienthanh.model.Android_Phone;
import com.tienthanh.service.IAndroid_PhoneService;
import com.tienthanh.service.Impl.Android_PhoneServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.format.annotation.DateTimeFormat;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
//@RequestMapping(value = "/tienthanh", method = RequestMethod.GET)
@RequestMapping("/tienthanh")
public class Android_PhoneController {
    @Autowired
    private IAndroid_PhoneService android_phoneService;
    @GetMapping("")
    public String listAndroid_Phone(Model model) {
        model.addAttribute("listAndroid_Phone", android_phoneService.displayAndroid_Phone());
        model.addAttribute("android_phone", new Android_Phone());

//        ModelAndView modelAndView = new ModelAndView("listAndroid_Phone");
//        modelAndView.addObject("listAndroid_Phone", android_phoneService.displayAndroid_Phone());
//        modelAndView.addObject("Android_phone", new Android_Phone());
//        return modelAndView;
        return "listAndroid_Phone";
    }

    @PostMapping("save_create_android_phone")
        public String aaaa(@ModelAttribute Android_Phone android_phone, Model model){
//        model.addAttribute("listAndroid_Phone", android_phoneService.displayAndroid_Phone());
//        model.addAttribute("Android_phone", new Android_Phone());
////        android_phoneService.add_New_Android_Phone(android_phone);
        System.out.println("kkkkkkkkkkkk");
        return "listAndroid_Phone";
    }
}
