package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.CartDto;
import com.bridgelabz.bookstore.exception.CartException;
import com.bridgelabz.bookstore.model.Cart;
import com.bridgelabz.bookstore.repository.ICartRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements ICartService {

    @Autowired
    private ICartRepository cartRepository;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * @param cartDto
     * @return Add books into the cart which is to be purchased
     */
    @Override
    public Cart addBookToCart(CartDto cartDto) {
        Cart cart = modelMapper.map(cartDto, Cart.class);
        return cartRepository.save(cart);
    }

    /**
     * @return List of all books present inside the cart
     */
    @Override
    public List<Cart> getListOfBooksInCart() {
        return cartRepository.findAll();
    }

    /**
     * @param bookId
     * @param bookQuantity
     * @return Update book quantity of particular book id
     * @throws CartException
     */
    @Override
    public Cart updateCart(long bookId, long bookQuantity) throws CartException {
        Cart cart = cartRepository.findById(bookId).get();
        if (cart == null)
            throw new CartException(CartException.ExceptionType.BOOK_IS_NOT_AVAILABLE, "BOOK_IS_NOT_AVAILABLE");
        cart.setQuantity(bookQuantity);
        return cartRepository.save(cart);
    }

    /**
     * @param bookId
     * @throws CartException
     */
    @Override
    public void removeBookFromCart(long bookId) throws CartException {
        if (cartRepository.findById(bookId).isPresent())
            cartRepository.deleteById(bookId);
        throw new CartException(CartException.ExceptionType.INVALID_BOOK_ID, "INVALID_BOOK_ID");
    }

    /**
     * Remove all books inside the cart
     */
    @Override
    public void removeAllBooks() {
        cartRepository.deleteAll();
    }
}
