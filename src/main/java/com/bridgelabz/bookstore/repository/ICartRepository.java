package com.bridgelabz.bookstore.repository;

import com.bridgelabz.bookstore.model.Book;
import com.bridgelabz.bookstore.model.Cart;
import com.bridgelabz.bookstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findAllByUserEquals(User user);

    Cart findByBookEqualsAndUserEquals(Book book, User user);

    void deleteCartByUserEquals(User user);
}
