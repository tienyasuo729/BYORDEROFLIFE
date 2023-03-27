package com.example.quan_ly_nhan_su.controller;

import com.example.quan_ly_nhan_su.service.IEmployeeService;
import com.example.quan_ly_nhan_su.service.impl.EmployeeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EmployeeListServlet", value = "/EmployeeListServlet")
public class EmployeeListServlet extends HttpServlet {
    private IEmployeeService employeeService = new EmployeeService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("employeeList", this.employeeService.listEmployee());
        request.getRequestDispatcher("users/listEmployee.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
