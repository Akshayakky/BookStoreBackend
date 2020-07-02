package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.CartDto;
import com.bridgelabz.bookstore.exception.CartException;
import com.bridgelabz.bookstore.model.Cart;

import java.util.List;

public interface ICartService {

    Cart addBookToCart(CartDto cartDto);

    List<Cart> getListOfBooksInCart(String email);

    Cart updateCart(Long bookId, Long quantity, String email) throws CartException;

    void removeBookFromCart(Long bookId, String email) throws CartException;

    void removeAllBooks(String email);
}
