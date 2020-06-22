package com.bridgelabz.bookstore.controller;

import com.bridgelabz.bookstore.dto.OrderDTO;
import com.bridgelabz.bookstore.model.MyOrder;
import com.bridgelabz.bookstore.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {

    @Autowired
    IOrderService iOrderService;

    /**
     * @param orderDTO - Ordered book details
     * @return - Details of book purchased by user
     */
    @PostMapping
    public MyOrder addOrder(@RequestBody OrderDTO orderDTO) {
        return iOrderService.addOrder(orderDTO);
    }

    /**
     * @param userId - Id to get order of particular user
     * @return All order details of user
     */
    @GetMapping("/{userId}")
    public List<MyOrder> getAllOrders(@PathVariable long userId) {
        return iOrderService.getAllOrders(userId);
    }
}
