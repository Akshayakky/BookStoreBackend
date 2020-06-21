package com.bridgelabz.bookstore.controller;

import com.bridgelabz.bookstore.dto.OrderDTO;
import com.bridgelabz.bookstore.model.MyOrder;
import com.bridgelabz.bookstore.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/order")
public class OrderController {

    @Autowired
    IOrderService iOrderService;

    /**
     * @param orderDTO
     * @return
     */
    @PostMapping
    public MyOrder addOrder(@RequestBody OrderDTO orderDTO) {
        return iOrderService.addOrder(orderDTO);
    }

    /**
     * @param userId
     * @return All order details of user
     */
    @GetMapping("/{userId}")
    public List<MyOrder> getAllOrders(@PathVariable long userId) {
        return iOrderService.getAllOrders(userId);
    }
}
