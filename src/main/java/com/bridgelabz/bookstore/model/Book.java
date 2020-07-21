package com.bridgelabz.bookstore.model;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookId;
    private String bookAuthor;
    private String bookTitle;
    private String bookImage;
    private int bookQuantity;
    private double bookPrice;
    @Column(columnDefinition = "TEXT")
    private String bookDescription;

    public Book() {
    }

    public Book(String bookAuthor, String bookTitle, String bookImage, int bookQuantity, double bookPrice, String bookDescription) {
        this.bookAuthor = bookAuthor;
        this.bookTitle = bookTitle;
        this.bookImage = bookImage;
        this.bookQuantity = bookQuantity;
        this.bookPrice = bookPrice;
        this.bookDescription = bookDescription;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookImage() {
        return bookImage;
    }

    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }

    public int getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(int bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }
}
