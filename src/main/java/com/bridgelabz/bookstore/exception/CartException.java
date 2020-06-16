package com.bridgelabz.bookstore.exception;

public class CartException extends Exception {
    public ExceptionType type;

    public CartException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }

    public enum ExceptionType {
        BOOK_IS_NOT_AVAILABLE, INVALID_BOOK_ID
    }

}
