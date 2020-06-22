package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.OrderDTO;
import com.bridgelabz.bookstore.model.MyOrder;
import com.bridgelabz.bookstore.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    OrderRepository orderRepository;

    /**
     * @param orderDTO - Ordered book details
     * @return Add order details to database
     */
    @Override
    public MyOrder addOrder(OrderDTO orderDTO) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        MyOrder myOrder = modelMapper.map(orderDTO, MyOrder.class);
        return orderRepository.save(myOrder);
    }

    /**
     * @param userId - Id to get order of particular user
     * @return All orders of user
     */
    @Override
    public List<MyOrder> getAllOrders(long userId) {
        return orderRepository.findAllByUserId(userId);
    }
}
