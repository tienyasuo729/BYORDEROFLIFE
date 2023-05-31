package com.example.test_many_to_many.controller;

import com.example.test_many_to_many.Service.Impl.IMiddServiceImpl;
import com.example.test_many_to_many.Service.Impl.UserServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@WebServlet(name = "TienThanhServlet", value = "/tienthanh")
public class TienThanhServlet extends HttpServlet {
    private UserServiceImpl userService;
    private IMiddServiceImpl middService;


    public void init() {
        userService = new UserServiceImpl();
        middService = new IMiddServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        listUser(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        String action2 = request.getParameter("action2");
        if (action == null) {
            action = "";
        }
        System.out.println();
        if (action2 == null) {
            action2 = "";
        }
        switch (action2) {

        }
        switch (action) {

        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listMidd", middService.list_midd());
        request.getRequestDispatcher("listAndroid_Phone.jsp").forward(request,response);
    }

}
