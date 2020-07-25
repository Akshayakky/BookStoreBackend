package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.CartDto;
import com.bridgelabz.bookstore.exception.CartException;
import com.bridgelabz.bookstore.model.Cart;
import com.bridgelabz.bookstore.repository.IBookRepository;
import com.bridgelabz.bookstore.repository.ICartRepository;
import com.bridgelabz.bookstore.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CartServiceImpl implements ICartService {

    @Autowired
    private ICartRepository cartRepository;

    @Autowired
    private IBookRepository bookRepository;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * @param cartDto - Book details
     * @return Add books into the cart which is to be purchased
     */
    @Override
    public Cart addBookToCart(CartDto cartDto) throws CartException {
        Cart cart = modelMapper.map(cartDto, Cart.class);
        if (cartRepository.findByBookEqualsAndUserEquals(cartDto.getBook(), cartDto.getUser()).isPresent())
            throw new CartException(CartException.ExceptionType.ALREADY_PRESENT, "Book Already Present");
        return cartRepository.save(cart);
    }

    /**
     * @param email - email Id of user cart belongs to
     * @return List of all books present inside the cart
     */
    @Override
    public List<Cart> getListOfBooksInCart(String email) {
        return cartRepository.findAllByUserEqualsOrderByBook(userRepository.findByEmail(email).get());
    }

    /**
     * @param bookId       - Book Id for update book quantity
     * @param bookQuantity - updated book quantity
     * @param email        - email of user cart belongs to
     * @return Update book quantity of particular book id
     * @throws CartException
     */
    @Override
    public Cart updateCart(Long bookId, Long bookQuantity, String email) throws CartException {
        Optional<Cart> carts = cartRepository.findByBookEqualsAndUserEquals(bookRepository.findById(bookId).get()
                , userRepository.findByEmail(email).get());
        Cart cart = carts.orElseThrow(() -> new CartException(CartException.ExceptionType.INVALID_BOOK_ID, "INVALID_BOOK_ID"));
        cart.setQuantity(bookQuantity);
        return cartRepository.save(cart);
    }

    /**
     * @param bookId - Book Id for removing book from cart
     * @param email  - email of user cart belongs to
     * @throws CartException
     */
    @Override
    public void removeBookFromCart(Long bookId, String email) throws CartException {
        Optional<Cart> carts = cartRepository.findByBookEqualsAndUserEquals(bookRepository.findById(bookId).get()
                , userRepository.findByEmail(email).get());
        Cart cart = carts.orElseThrow(() -> new CartException(CartException.ExceptionType.INVALID_BOOK_ID, "INVALID_BOOK_ID"));
        cartRepository.deleteById(cart.getItemId());
    }

    /**
     * @param email - email Id of user cart belongs to
     */
    @Override
    public void removeAllBooks(String email) {
        cartRepository.deleteCartByUserEquals(userRepository.findByEmail(email).get());
    }
}
