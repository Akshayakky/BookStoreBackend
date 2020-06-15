package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.exception.BookStoreException;
import com.bridgelabz.bookstore.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> getBookList();

    List<Book> getBookByFilter(String filter) throws BookStoreException;

    List<Book> getBookById(Long[] id);

    List<Book> getBookBySort(String sort);
}
