package com.bridgelabz.bookstore.repository;

import com.bridgelabz.bookstore.model.MyOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<MyOrder, Long> {
    List<MyOrder> findAllByUserId(long userId);

}
