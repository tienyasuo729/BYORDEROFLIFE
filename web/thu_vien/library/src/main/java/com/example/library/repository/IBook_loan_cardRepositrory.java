package com.example.library.repository;

import com.example.library.model.Book;
import com.example.library.model.Book_loan_card;
import com.example.library.model.Form_borrow_book;
import com.example.library.model.Student;

import java.util.ArrayList;
import java.util.List;

public interface IBook_loan_cardRepositrory {
    void create_book_loan_card(Book_loan_card book_loan_card);

    List<Form_borrow_book> display_form_borrow_book();
}
