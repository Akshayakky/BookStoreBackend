package com.bridgelabz.bookstore.dto;

import com.bridgelabz.bookstore.model.Book;
import com.bridgelabz.bookstore.model.User;

public class CartDto {
    private User user;
    private Book book;
    private Long quantity;

    public CartDto(User user, Book book, Long quantity) {
        this.user = user;
        this.book = book;
        this.quantity = quantity;
    }

    public CartDto() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
