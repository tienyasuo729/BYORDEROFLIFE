package com.example.tien_thanh.controller;

import com.example.tien_thanh.Service.ICccdService;
import com.example.tien_thanh.Service.IDetailService;
import com.example.tien_thanh.Service.Impl.CccdServiceImpl;
import com.example.tien_thanh.Service.Impl.DetailServiceImpl;
import com.example.tien_thanh.model.CCCD;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@WebServlet(name = "TienThanhServlet", value = "/tienthanh")
public class TienThanhServlet extends HttpServlet {
    private ICccdService cccdService;
    private IDetailService detailService;

    public void init() {
        cccdService = new CccdServiceImpl();
        detailService = new DetailServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        listProduct(request, response);
//        String action = request.getParameter("action");
//        if (action == null) {
//            action = "";
//        }
//        System.out.println("get");
//        System.out.println(action);
//        switch (action) {
//            case "create":
//                showNewForm(request, response);
//                break;
//            case "edit":
//                edit(request, response);
//                break;
//            case "delete":
//                deleteNhanVien(request, response);
//                break;
//            default:
//                listProduct(request, response);
//                break;
//        }
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
        if (action2 == null) {
            action2 = "";
        }
//        switch (action2) {
//            case "Save":
//                insertProduct(request, response);
//                break;
//            case "Edit":
//                updateUser(request, response);
//                break;
//            case "search":
//                searchByCountry(request, response);
//                break;
//            case "delete":
//                deleteNhanVien(request, response);
//                break;
//        }
//        switch (action) {
//            case "create":
//                createForm(request, response);
//                break;
//            case "edit":
//                edit(request, response);
//                break;
//            case "list":
//                listProduct(request, response);
//                break;
//        }
    }
    private void listProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<CCCD> listProduct = productService.listProduct();
        request.setAttribute("listCCCD", cccdService.displayCCCD());
        request.getRequestDispatcher("/listCCCD.jsp").forward(request, response);
    }

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
