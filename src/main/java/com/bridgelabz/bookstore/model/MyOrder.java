package com.bridgelabz.bookstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class MyOrder {
    @Id
    @GeneratedValue
    long orderId;
    long bookId;
    long totalPrice;
    long bookQuantity;
    long user;

    public long getUser() {
        return user;
    }

    public void setUser(long user) {
        this.user = user;
    }

    public long getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(long bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }
}
