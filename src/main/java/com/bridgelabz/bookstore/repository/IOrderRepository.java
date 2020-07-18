package com.bridgelabz.bookstore.repository;

import com.bridgelabz.bookstore.model.MyOrder;
import com.bridgelabz.bookstore.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IOrderRepository extends CrudRepository<MyOrder, Long> {
    List<MyOrder> findAllByUser(User user);

}
