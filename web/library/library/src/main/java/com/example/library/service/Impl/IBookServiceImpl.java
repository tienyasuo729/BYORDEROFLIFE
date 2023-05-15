package com.example.library.service.Impl;

import com.example.library.model.Book;
import com.example.library.repository.impl.BookRepositoryImpl;
import com.example.library.service.IBookService;

import java.util.List;

public class IBookServiceImpl implements IBookService {
    private BookRepositoryImpl bookRepository = new BookRepositoryImpl();
    @Override
    public List<Book> find_all_book() {
        return bookRepository.find_all_book();
    }
}
