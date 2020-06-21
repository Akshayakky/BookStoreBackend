package com.bridgelabz.bookstore.repository;

import com.bridgelabz.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookRepository extends JpaRepository<Book, Long> {

    List<Book> findBooksByBookAuthorContainsOrBookTitleContainsOrderByBookPriceDesc(String bookAuthor, String bookTitle);

    List<Book> findBooksByBookAuthorContainsOrBookTitleContainsOrderByBookQuantity(String bookAuthor, String bookTitle);

    List<Book> findBooksByBookAuthorContainsOrBookTitleContainsOrderByBookPrice(String bookAuthor, String bookTitle);

    List<Book> findBooksByBookAuthorContainsOrBookTitleContainsOrderByBookId(String bookAuthor, String bookTitle);

    List<Book> findBooksByBookAuthorContainsOrBookTitleContains(String bookAuthor, String bookTitle);
}
