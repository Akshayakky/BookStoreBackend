package com.bridgelabz.bookstore.repository;

import com.bridgelabz.bookstore.model.MyOrder;
import com.bridgelabz.bookstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IOrderRepository extends JpaRepository<MyOrder, Long> {
    List<MyOrder> findAllByUser(User user);

}
