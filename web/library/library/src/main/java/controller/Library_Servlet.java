package controller;


import service.Impl.IBookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@WebServlet(name = "library_Servlet", value = "/library_Servlet")
public class Library_Servlet extends HttpServlet {
    private IBookServiceImpl bookService = new IBookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List_book(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String post_action = request.getParameter("post_action");

        if (post_action == null) {
            post_action = "";
        }

        switch (post_action){
            case "button_borrow_book":
                Form_borrow_book(request,response);
                break;
        }
    }



    private void List_book(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list_book", bookService.find_all_book());
        request.getRequestDispatcher("list_book.jsp").forward(request,response);
    }

    private void Form_borrow_book(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
        Date now = new Date();
        switch ()
        String date_borrow_book = (now.getYear() + 1900) + "-" + (now.getMonth() + 1) + "-" + now.getDate();
        System.out.println(date_borrow_book);
        request.setAttribute("create_id_book", request.getParameter("id_book_borrow"));
        request.setAttribute("create_name_book", request.getParameter("name_borrow_book"));
        request.setAttribute("create_date_borrow_book", date_borrow_book);
        request.getRequestDispatcher("form_borrow_book.jsp").forward(request,response);
    }
}
