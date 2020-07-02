package com.bridgelabz.bookstore.controller;

import com.bridgelabz.bookstore.dto.CartDto;
import com.bridgelabz.bookstore.exception.CartException;
import com.bridgelabz.bookstore.model.Cart;
import com.bridgelabz.bookstore.repository.IUserRepository;
import com.bridgelabz.bookstore.service.ICartService;
import com.bridgelabz.bookstore.utility.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@CrossOrigin
public class CartController {

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    private ICartService cartService;

    @Autowired
    private IUserRepository userRepository;

    /**
     * @param cartDto - Book details
     * @return Add book to cart for purchase
     */
    @PostMapping
    public Cart addBookToCart(@RequestHeader("Authorization") String authenticate, @RequestBody CartDto cartDto) {
        cartDto.setUser(userRepository.findByEmail(jwtUtil.extractUsername(authenticate.substring(7))).get());
        return cartService.addBookToCart(cartDto);
    }

    /**
     * @param bookId   - BookId for update book quantity
     * @param quantity - Updated book quantity
     * @return Update quantity of book of particular book
     * @throws CartException
     */
    @PutMapping("/{quantity}")
    public Cart updateCart(@RequestHeader("Authorization") String authenticate, @RequestParam(value = "book_id")
            Long bookId, @PathVariable Long quantity) throws CartException {
        return cartService.updateCart(bookId, quantity, jwtUtil.extractUsername(authenticate.substring(7)));
    }

    /**
     * @param bookId - bookId to remove book from cart
     * @throws CartException
     */
    @DeleteMapping("/delete-book/{book-id}")
    public void removeBookFromCart(@PathVariable(value = "book-id") Long bookId
            , @RequestHeader("Authorization") String authenticate) throws CartException {
        cartService.removeBookFromCart(bookId, jwtUtil.extractUsername(authenticate.substring(7)));
    }

    /**
     * @return Books List in the cart
     */
    @GetMapping
    public List<Cart> getListOfBooksInCart(@RequestHeader("Authorization") String authenticate) {
        return cartService.getListOfBooksInCart(jwtUtil.extractUsername(authenticate.substring(7)));
    }

    /**
     * Remove all books from cart
     */
    @DeleteMapping("/empty-cart")
    public void removeAllBooks(@RequestHeader("Authorization") String authenticate) {
        cartService.removeAllBooks(jwtUtil.extractUsername(authenticate.substring(7)));
    }
}











