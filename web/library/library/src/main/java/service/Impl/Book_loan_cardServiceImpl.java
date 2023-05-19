package service.Impl;

import connections.BaseRepository;
import model.Book_loan_card;
import repository.impl.Book_loan_cardRepositoryImpl;
import service.IBook_loan_cardService;

public class Book_loan_cardServiceImpl implements IBook_loan_cardService {
    private Book_loan_cardRepositoryImpl book_loan_cardRepository = new Book_loan_cardRepositoryImpl();
    @Override
    public void create_book_loan_card(Book_loan_card book_loan_card) {
        book_loan_cardRepository.create_book_loan_card(book_loan_card);
    }
}
