package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.OrderDTO;
import com.bridgelabz.bookstore.model.MyOrder;
import com.bridgelabz.bookstore.repository.IOrderRepository;
import com.bridgelabz.bookstore.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    IOrderRepository orderRepository;

    @Autowired
    IUserRepository userRepository;

    /**
     * @param orderDTO - Ordered book details
     * @return Add order details to database
     */
    @Override
    public MyOrder addOrder(OrderDTO orderDTO, String email) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        orderDTO.setUser(userRepository.findByEmail(email).get());
        orderDTO.setDate(LocalDate.now());
        MyOrder myOrder = modelMapper.map(orderDTO, MyOrder.class);
        return orderRepository.save(myOrder);
    }

    /**
     * @param email - user email
     * @return All orders of user
     */
    @Override
    public List<MyOrder> getUserOrders(String email) {
        return orderRepository.findAllByUser(userRepository.findByEmail(email).get());
    }


    /**
     * @return All orders
     */
    @Override
    public List<MyOrder> getAllOrders() {
        return orderRepository.findAll();
    }
}
