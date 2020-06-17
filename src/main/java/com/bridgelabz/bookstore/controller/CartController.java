package com.bridgelabz.bookstore.controller;

import com.bridgelabz.bookstore.dto.CartDto;
import com.bridgelabz.bookstore.exception.CartException;
import com.bridgelabz.bookstore.model.Cart;
import com.bridgelabz.bookstore.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "http://localhost:3000")

public class CartController {

    @Autowired
    private ICartService cartService;

    /**
     * @param cartDto
     * @return Add book to cart for purchase
     */
    @PostMapping
    public Cart addBookToCart(@RequestBody CartDto cartDto) {
        return cartService.addBookToCart(cartDto);
    }

    /**
     * @param bookId
     * @param quantity
     * @return Update quantity of book of particular book
     * @throws CartException
     */
    @PutMapping("/{quantity}")
    public Cart updateCart(@RequestParam(value = "book_id") Long bookId, @PathVariable Long quantity) throws CartException {
        return cartService.updateCart(bookId, quantity);
    }

    /**
     * @param bookId
     * @throws CartException
     */
    @DeleteMapping("/delete-book/{book-id}")
    public void removeBookFromCart(@PathVariable(value = "book-id") Long bookId) throws CartException {
        cartService.removeBookFromCart(bookId);
    }

    /**
     * @return Books List in the cart
     */
    @GetMapping
    public List<Cart> getListOfBooksInCart() {
        return cartService.getListOfBooksInCart();
    }

    /**
     * Remove all books from cart
     */
    @DeleteMapping("/empty-cart")
    public void removeAllBooks() {
        cartService.removeAllBooks();
    }
}











