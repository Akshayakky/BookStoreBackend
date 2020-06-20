package com.bridgelabz.bookstore.repository;

import com.bridgelabz.bookstore.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findAllByUserIdEquals(Long userId);

    Cart findByBookIdEqualsAndUserIdEquals(Long bookId, Long userId);

    void deleteCartByUserIdEquals(Long userId);
}
