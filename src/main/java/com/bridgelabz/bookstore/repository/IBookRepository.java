package com.bridgelabz.bookstore.repository;

import com.bridgelabz.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookRepository extends JpaRepository<Book, Long> {

    List<Book> findBooksByBookAuthorContainsIgnoreCaseOrBookTitleContainsIgnoreCaseOrderByBookPriceDesc(String bookAuthor, String bookTitle);

    List<Book> findBooksByBookAuthorContainsIgnoreCaseOrBookTitleContainsIgnoreCaseOrderByBookQuantity(String bookAuthor, String bookTitle);

    List<Book> findBooksByBookAuthorContainsIgnoreCaseOrBookTitleContainsIgnoreCaseOrderByBookPrice(String bookAuthor, String bookTitle);

    List<Book> findBooksByBookAuthorContainsIgnoreCaseOrBookTitleContainsIgnoreCaseOrderByBookId(String bookAuthor, String bookTitle);
}
