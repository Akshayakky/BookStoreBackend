package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.CartDto;
import com.bridgelabz.bookstore.exception.CartException;
import com.bridgelabz.bookstore.model.Cart;
import com.bridgelabz.bookstore.repository.ICartRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CartServiceImpl implements ICartService {

    @Autowired
    private ICartRepository cartRepository;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * @param cartDto - Book details
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
    public List<Cart> getListOfBooksInCart(Long userId) {
        return cartRepository.findAllByUserIdEquals(userId);
    }

    /**
     * @param bookId - BookId for update book quantity
     * @param bookQuantity - updated book quantity
     * @return Update book quantity of particular book id
     * @throws CartException
     */
    @Override
    public Cart updateCart(Long bookId, Long bookQuantity, Long userId) throws CartException {
        Cart cart = cartRepository.findByBookIdEqualsAndUserIdEquals(bookId, userId);
        if (cart == null)
            throw new CartException(CartException.ExceptionType.INVALID_BOOK_ID, "INVALID_BOOK_ID");
        cart.setQuantity(bookQuantity);
        return cartRepository.save(cart);
    }

    /**
     * @param bookId
     * @throws CartException
     */
    @Override
    public void removeBookFromCart(Long bookId, Long userId) throws CartException {
        Cart cart = cartRepository.findByBookIdEqualsAndUserIdEquals(bookId, userId);
        if (cart == null)
            throw new CartException(CartException.ExceptionType.INVALID_BOOK_ID, "INVALID_BOOK_ID");
        cartRepository.deleteById(cart.getCartId());
    }

    /**
     * Remove all books inside the cart
     */
    @Override
    public void removeAllBooks(Long userId) {
        cartRepository.deleteCartByUserIdEquals(userId);
    }
}
