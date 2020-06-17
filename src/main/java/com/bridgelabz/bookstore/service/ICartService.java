package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.CartDto;
import com.bridgelabz.bookstore.exception.CartException;
import com.bridgelabz.bookstore.model.Cart;

import java.util.List;

public interface ICartService {

    Cart addBookToCart(CartDto cartDto);

    List<Cart> getListOfBooksInCart();

    Cart updateCart(Long bookId, Long quantity) throws CartException;

    void removeBookFromCart(Long bookId) throws CartException;

    void removeAllBooks();
}
