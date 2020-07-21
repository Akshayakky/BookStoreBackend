package com.bridgelabz.bookstore.dto;

public class BookDto {

    private String bookAuthor;
    private String bookTitle;
    private String bookImage;
    private long bookQuantity;
    private long bookPrice;
    private String bookDescription;

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

    public long getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(long bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    public long getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(long bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }
}
