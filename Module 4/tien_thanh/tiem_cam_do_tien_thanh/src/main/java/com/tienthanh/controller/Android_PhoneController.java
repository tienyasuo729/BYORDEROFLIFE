package com.tienthanh.controller;

import com.tienthanh.model.Android_Phone;
import com.tienthanh.service.IAndroid_PhoneService;
import com.tienthanh.service.Impl.Android_PhoneServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    private String listAndroid_Phone(Model model) {
        List<Android_Phone> androidPhones = android_phoneService.displayAndroid_Phone();
//        System.out.println(androidPhones.get(1).getStart_Date().getMonth());
        model.addAttribute("listAndroid_Phone", androidPhones);
        return "listAndroid_Phone";
    }
}
