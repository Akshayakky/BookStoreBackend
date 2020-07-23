package com.bridgelabz.bookstore.dto;

import com.bridgelabz.bookstore.model.Book;
import com.bridgelabz.bookstore.model.Customer;
import com.bridgelabz.bookstore.model.User;

import java.time.LocalDate;

public class OrderDTO {
    private Book book;
    private Long totalPrice;
    private Long bookQuantity;
    private User user;
    private Customer customer;
    private LocalDate date;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Long getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(Long bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}