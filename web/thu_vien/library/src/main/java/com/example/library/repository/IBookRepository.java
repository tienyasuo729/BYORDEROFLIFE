package com.example.library.repository;



import com.example.library.model.Book;

import java.util.List;

public interface IBookRepository {
    List<Book> find_all_book();
}
