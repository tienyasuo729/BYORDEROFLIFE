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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        android_phoneService.delete_Android_Phone(id_need_to_delete);
//        tìm cách để quay lại trang list mà không cần phải tải lại nguyên danh sách cho tốn dung lượng
//        request.setAttribute("listAndroid_Phone", androidPhones);
//        request.getRequestDispatcher("Android_Phone/listAndroid_Phone.jsp").forward(request, response);
    }

    private void listAndroid_Phone(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Android_Phone> androidPhones = android_phoneService.displayAndroid_Phone();
        System.out.println(androidPhones.get(2).getStart_Date().getTime() - androidPhones.get(0).getStart_Date().getTime());
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

//    private void watchDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String id = request.getParameter("idDetail");
//        request.setAttribute("DETAIL", detailService.finDetailByid(id));
//        request.getRequestDispatcher("").forward(request,response);
//    }
//
//    private void listCCCD(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setAttribute("listCCCD", cccdService.displayCCCD());
//        request.getRequestDispatcher("/listCCCD.jsp").forward(request, response);
//    }
//    private void listDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setAttribute("listDetail", detailService.displayDetail());
//        request.getRequestDispatcher("/listDetail.jsp").forward(request, response);
//    }
//    private void createForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setAttribute("listCategory", categoryService.findAll());
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/create.jsp");
//        dispatcher.forward(request, response);
//    }
//
//    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String editId = request.getParameter("idEdit");
//        request.setAttribute("productDetail", productService.findByIdOfProduct(editId));
//        request.setAttribute("listCategory", categoryService.findAll());
//        request.setAttribute("product", editId);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/edit.jsp");
//        dispatcher.forward(request, response);
//    }
//
//    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        String editId = request.getParameter("idEdit");
//        String name = request.getParameter("name");
//        int price = Integer.parseInt(request.getParameter("price"));
//        int quantity = Integer.parseInt(request.getParameter("quantity"));
//        String [] colorAfter = request.getParameterValues("color[]");
//        String color = Arrays.toString(colorAfter);
//        color = color.substring(1, color.length() - 1);
//        String description = request.getParameter("description");
//        String category = request.getParameter("category");
////        Product product = productService.findById(maCongViec);
//        Product product = new Product(editId, name, price, quantity, color, description, category);
//        productService.update(product);
//        response.sendRedirect("/list");
//
//    }
//
//    private void deleteNhanVien(HttpServletRequest request, HttpServletResponse response) {
//        productService.delete(request.getParameter("id"));
////        int check = productService.delete(request.getParameter("id"));
////        if (check == 0){
////            request.setAttribute("deleteById", "Xoá sản phẩm không thành công");
////        }else {
////            request.setAttribute("deleteById", "Xoá sản phẩm thành công");
////        }
////        try {
////            request.getRequestDispatcher("/listCCCD.jsp").forward(request,response);
////        } catch (ServletException e) {
////            throw new RuntimeException(e);
////        } catch (IOException e) {
////            throw new RuntimeException(e);
////        }
//        try {
//            response.sendRedirect("/list");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//    private void searchByCountry(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String findName = request.getParameter("findName");
//        List<Product> listProduct = productService.findByNameOfProduct(findName);
//        request.setAttribute("listFindByName", listProduct);
//        request.getRequestDispatcher("/findByName.jsp").forward(request, response);
//    }
//
//    private void insertProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String id = request.getParameter("id");
//        String name = request.getParameter("name");
//        int price = Integer.parseInt(request.getParameter("price"));
//        int quantity = Integer.parseInt(request.getParameter("quantity"));
//        String [] colorAfter = request.getParameterValues("color[]");
//        String color = Arrays.toString(colorAfter);
//        color = color.substring(1, color.length() - 1);
//        String description = request.getParameter("description");
//        String category = request.getParameter("category");
////        Product product = productService.findById(maCongViec);
//        Product product = new Product(id, name, price, quantity, color, description, category);
//        productService.add(product);
//        response.sendRedirect("/list");
//    }

}
