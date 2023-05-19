package com.example.library.repository.impl;


import com.example.library.connections.BaseRepository;
import com.example.library.model.Book_loan_card;
import com.example.library.model.Form_borrow_book;
import com.example.library.repository.IBook_loan_cardRepositrory;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Book_loan_cardRepositoryImpl implements IBook_loan_cardRepositrory {
    private BaseRepository baseRepository = new BaseRepository();

    private String CREATE_BOOK_LOAN_CARD = "INSERT into book_loan_card(id_loan_card, id_book, id_student, status_loan_card, borrowed_date, return_date) values (?,?,?,?,?,?)";

    private String DISPLAY_FORM_BORROW_BOOK = "SELECT blc.id_loan_card, b.name_book, b.author_book, s.name_student, s.class_student, blc.borrowed_date, blc.return_date FROM book_loan_card blc JOIN book b ON blc.id_book = b.id_book JOIN student s ON blc.id_student = s.id_student";
    @Override
    public void create_book_loan_card(Book_loan_card book_loan_card) {
        int status_loan_card = 0;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(CREATE_BOOK_LOAN_CARD);
            preparedStatement.setString(1, book_loan_card.getId_loan_card());
            preparedStatement.setString(2, book_loan_card.getId_book());
            preparedStatement.setString(3, book_loan_card.getId_student());

            // Chuyển đổi boolean trong status book_loan_card thành kiểu bit trong mySQL
            if (book_loan_card.isStatus_loan_card()){
                status_loan_card = 1;
            }
            preparedStatement.setInt(4, status_loan_card);

            preparedStatement.setDate(5, new Date(book_loan_card.getBorrowed_date().getTime()));
            preparedStatement.setDate(6, new Date(book_loan_card.getReturn_date().getTime()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Form_borrow_book> display_form_borrow_book() {
        List<Form_borrow_book> borrowBookList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(DISPLAY_FORM_BORROW_BOOK);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return borrowBookList;
    }
}
