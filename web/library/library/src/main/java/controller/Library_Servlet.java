package controller;


import model.Book_loan_card;
import model.Student;
import service.Impl.BookServiceImpl;
import service.Impl.Book_loan_cardServiceImpl;
import service.Impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@WebServlet(name = "library_Servlet", value = "/library")
public class Library_Servlet extends HttpServlet {
    private BookServiceImpl bookService = new BookServiceImpl();

    private StudentServiceImpl studentService = new StudentServiceImpl();

    private Book_loan_cardServiceImpl book_loan_cardService = new Book_loan_cardServiceImpl();
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
            case "return_form_create_loan_card":
                List_book(request,response);
                break;
            case "submit_create_loan_card":
                Create_loan_card(request,response);
                break;
        }
    }

    private void Create_loan_card(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String create_id_loan_card = request.getParameter("create_id_loan_card");
        String create_id_book = request.getParameter("create_id_book");
        String create_id_student = request.getParameter("create_name_student");
        Boolean create_status_loan_card = true;
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
        Date create_borrowed_date = null;
        Date create_return_date = null;
        try {
            create_borrowed_date = dateFormat.parse(request.getParameter("create_date_borrow_book"));
            create_return_date = dateFormat.parse(request.getParameter("create_date_return_book"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        book_loan_cardService.create_book_loan_card(new Book_loan_card(create_id_loan_card,create_id_book,create_id_student,create_status_loan_card,create_borrowed_date,create_return_date));
        List_book(request,response);
    }


    private void List_book(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list_book", bookService.find_all_book());
        request.getRequestDispatcher("list_book.jsp").forward(request,response);
    }

    private void Form_borrow_book(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy ngày hiện tại để chuyển sang cho ngày mượn trong trang mượn sách
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date_borrow_book = dateFormat.format(now);

        // lấy danh sách tên hoc sinh để truyền xuống trang mượn sách
        List<Student> studentList = studentService.Find_id_and_name_of_student();

        //truyền dữ liệu gồm id, tên, ngày mượn vào trang mượn sách
        request.setAttribute("create_id_book", request.getParameter("id_book_borrow"));
        request.setAttribute("create_name_book", request.getParameter("name_borrow_book"));
        request.setAttribute("create_date_borrow_book", date_borrow_book);
        request.setAttribute("list_student_for_form_create_loan_card", studentList);
        request.getRequestDispatcher("form_borrow_book.jsp").forward(request,response);
    }
}
