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
@CrossOrigin
public class CartController {

    @Autowired
    private ICartService cartService;

    /**
     * @param cartDto - Book details
     * @return Add book to cart for purchase
     */
    @PostMapping
    public Cart addBookToCart(@RequestBody CartDto cartDto) {
        return cartService.addBookToCart(cartDto);
    }

    /**
     * @param bookId   - BookId for update book quantity
     * @param quantity - Updated book quantity
     * @return Update quantity of book of particular book
     * @throws CartException
     */
    @PutMapping("/{quantity}")
    public Cart updateCart(@RequestParam(value = "book_id") Long bookId, @PathVariable Long quantity
            , @RequestParam(value = "user_id") Long userId) throws CartException {
        return cartService.updateCart(bookId, quantity, userId);
    }

    /**
     * @param bookId - bookId to remove book from cart
     * @throws CartException
     */
    @DeleteMapping("/delete-book/{book-id}")
    public void removeBookFromCart(@PathVariable(value = "book-id") Long bookId
            , @RequestParam(value = "user_id") Long userId) throws CartException {
        cartService.removeBookFromCart(bookId, userId);
    }

    /**
     * @return Books List in the cart
     */
    @GetMapping
    public List<Cart> getListOfBooksInCart(@RequestParam(value = "user_id") Long userId) {
        return cartService.getListOfBooksInCart(userId);
    }

    /**
     * Remove all books from cart
     */
    @DeleteMapping("/empty-cart")
    public void removeAllBooks(@RequestParam(value = "user_id") Long userId) {
        cartService.removeAllBooks(userId);
    }
}











