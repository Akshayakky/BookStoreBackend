package com.bridgelabz.bookstore.model;

import javax.persistence.*;

@Entity
@Table(name = "cart", uniqueConstraints = @UniqueConstraint(columnNames = {"book_id", "user_id"}))
public class Cart {

    @Id
    @GeneratedValue
    private long itemId;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    private long quantity;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Cart(Book book, long quantity, User user) {
        this.book = book;
        this.quantity = quantity;
        this.user = user;
    }

    public Cart() {
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
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

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
}
