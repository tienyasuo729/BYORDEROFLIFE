package repository.impl;

import connections.BaseRepository;
import model.Book_loan_card;
import repository.IBook_loan_cardRepositrory;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Book_loan_cardRepositoryImpl implements IBook_loan_cardRepositrory {
    private BaseRepository baseRepository = new BaseRepository();

    private String CREATE_BOOK_LOAN_CARD = "INSERT into book_loan_card(id_loan_card, id_book, id_student, status_loan_card, borrowed_date, return_date) values (?,?,?,?,?,?)";

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
            preparedStatement.setString(4, String.valueOf(status_loan_card));

            preparedStatement.setDate(5, new java.sql.Date(book_loan_card.getBorrowed_date().getTime()));
            preparedStatement.setDate(6, new java.sql.Date(book_loan_card.getReturn_date().getTime()));
            preparedStatement.executeUpdate();
            System.out.println("ggg");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
