package com.tienthanh.controller;

import com.tienthanh.model.Android_Phone;
import com.tienthanh.service.IAndroid_PhoneService;
import com.tienthanh.service.Impl.Android_PhoneServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    private IAndroid_PhoneService android_phoneService = new Android_PhoneServiceImpl();
    private void listAndroid_Phone(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Android_Phone> androidPhones = android_phoneService.displayAndroid_Phone();
//        System.out.println(androidPhones.get(1).getStart_Date().getMonth());
        request.setAttribute("listAndroid_Phone", androidPhones);
        request.getRequestDispatcher("Android_Phone/listAndroid_Phone.jsp").forward(request, response);
    }
}
