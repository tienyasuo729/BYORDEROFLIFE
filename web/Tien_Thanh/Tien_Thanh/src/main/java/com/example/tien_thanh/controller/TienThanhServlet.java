package com.example.tien_thanh.controller;

import com.example.tien_thanh.Service.IAndroid_PhoneService;
import com.example.tien_thanh.Service.ICccdService;
import com.example.tien_thanh.Service.IDetailService;
import com.example.tien_thanh.Service.Impl.Android_PhoneServiceImpl;
import com.example.tien_thanh.Service.Impl.CccdServiceImpl;
import com.example.tien_thanh.Service.Impl.DetailServiceImpl;
import com.example.tien_thanh.model.Android_Phone;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.TimeUnit;

@WebServlet(name = "TienThanhServlet", value = "/tienthanh")
public class TienThanhServlet extends HttpServlet {
    private ICccdService cccdService;
    private IDetailService detailService;
    private IAndroid_PhoneService android_phoneService;

    public void init() {
        cccdService = new CccdServiceImpl();
        detailService = new DetailServiceImpl();
        android_phoneService = new Android_PhoneServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        listAndroid_Phone(request,response);
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
            case "save_create_android_phone":
                create_Android_Phone(request,response);
                break;
            case "delete_android_phone_by_id":
                delete_android_phone_by_id(request,response);
                listAndroid_Phone(request,response);
                break;
            case "save_edit_android_phone":
                edit_android_phone(request,response);
                break;
            case "interestPayment":
                calculator_interest_payment(request,response);
                break;


        }
        switch (action) {
            case "create":
                Form_create_Android_Phone(request, response);
                break;
            case "list_Android_phone":
                listAndroid_Phone(request,response);
                break;
            case "edit_Android_phone":
                Form_edit_android_phone(request,response);
                break;





        }
    }

    private void calculator_interest_payment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dateString = request.getParameter("start_date_interest_payment");
        int price = Integer.parseInt(request.getParameter("price_interest_payment"));
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
        int interest_payment = 0;
        try {
            LocalDate startDate = LocalDate.parse(dateString, dateFormat);
            long daysBetween = ChronoUnit.DAYS.between(startDate, LocalDate.now());
            interest_payment = money(daysBetween, price);
            String result = "Khoảng cách giữa hai ngày là " + daysBetween + " ngày.";
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(result);
//            String jsCode = "alert(\"" + result + "\");";
//            response.getWriter().write("<script type='text/javascript'>" + jsCode + "</script>");

        } catch (DateTimeParseException e) {
            e.printStackTrace();
        }
    }

    private void edit_android_phone(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("idEdit");
        String name_owner = request.getParameter("name_ownerEdit");
        String name_phone = request.getParameter("name_phoneEdit");
        int price = Integer.parseInt(request.getParameter("priceEdit"));
        String status = request.getParameter("statusEdit");
        String password = request.getParameter("passwordEdit");
        String note = request.getParameter("noteEdit");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date start_Date = null;
        try {
            start_Date = dateFormat.parse(request.getParameter("start_DateEdit"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Android_Phone android_phone = new Android_Phone(id,name_owner,name_phone,price,start_Date,status,password,note);
        android_phoneService.edit_Android_Phone(android_phone);
        request.getRequestDispatcher("Android_Phone/listAndroid_Phone.jsp").forward(request,response);
    }

    private void Form_edit_android_phone(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_android_phone_edit = request.getParameter("id_need_to_edit");
        request.setAttribute("id_need_to_edit",id_android_phone_edit);
        request.getRequestDispatcher("Android_Phone/edit_Android_Phone.jsp").forward(request,response);
    }

    private void delete_android_phone_by_id(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_need_to_delete = request.getParameter("id_need_to_delete");
//        System.out.println("/1 " + id_need_to_delete);
        android_phoneService.delete_Android_Phone(id_need_to_delete);
//        tìm cách để quay lại trang list mà không cần phải tải lại nguyên danh sách cho tốn dung lượng
//        request.setAttribute("listAndroid_Phone", androidPhones);
//        request.getRequestDispatcher("Android_Phone/listAndroid_Phone.jsp").forward(request, response);
    }

    private void listAndroid_Phone(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Android_Phone> androidPhones = android_phoneService.displayAndroid_Phone();
//        System.out.println(androidPhones.get(1).getStart_Date().getMonth());
        request.setAttribute("listAndroid_Phone", androidPhones);
        request.getRequestDispatcher("Android_Phone/listAndroid_Phone.jsp").forward(request, response);
    }
    private void Form_create_Android_Phone(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("Android_Phone/createAndroid_Phone.jsp").forward(request, response);
    }
    private void create_Android_Phone(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        String name_owner = request.getParameter("name_owner");
        String name_phone = request.getParameter("name_phone");
        int price = Integer.parseInt(request.getParameter("price"));
        String status = request.getParameter("status");
        String password = request.getParameter("password");
        String note = request.getParameter("note");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date start_Date = null;
        try {
            start_Date = dateFormat.parse(request.getParameter("start_Date"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Android_Phone android_phone = new Android_Phone(id,name_owner,name_phone,price,start_Date,status,password,note);
        android_phoneService.add_New_Android_Phone(android_phone);
        request.getRequestDispatcher("Android_Phone/createAndroid_Phone.jsp").forward(request,response);
    }
    private int money(int day, int price){
        int payment = 0;
//        if (day <= 10 && price <= 2000000){
//            payment = ((price / 1000000) * 3000 + less_than_500(price)) * 10;
//        }
//        if (day > 10 && price <= 2000000){
//            payment = ((price / 1000000) * 3000 + less_than_500(price)) * day;
//        }
        if (day <= 10){
            payment = ((price / 1000000) * 3000 + less_than_500(price)) * 10;
        }else {
            payment = ((price / 1000000) * 3000 + less_than_500(price)) * day;
        }
        return payment;
    }

    private int less_than_500 (int price){
        int support = price % 1000000;
        if ( support == 0){
            return 0;
        }else if (support < 500){
            return 2000;
        }else {
            return 3000;
        }
    }
}
