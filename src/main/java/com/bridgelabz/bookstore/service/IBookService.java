package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.BookDto;
import com.bridgelabz.bookstore.exception.BookStoreException;
import com.bridgelabz.bookstore.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> getBookById(Long[] id);

    List<Book> getBookBySortAndSearch(String filter, String sort) throws BookStoreException;

    Book addBook(BookDto bookDto);

    void removeBook(Long bookId);
}
