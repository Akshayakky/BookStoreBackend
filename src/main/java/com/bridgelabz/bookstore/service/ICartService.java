package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.CartDto;
import com.bridgelabz.bookstore.exception.CartException;
import com.bridgelabz.bookstore.model.Cart;

import java.util.List;

public interface ICartService {

    Cart addBookToCart(CartDto cartDto);

    List<Cart> getListOfBooksInCart(Long userId);

    Cart updateCart(Long bookId, Long quantity, Long userId) throws CartException;

    void removeBookFromCart(Long bookId, Long userId) throws CartException;

    void removeAllBooks(Long userId);
}
