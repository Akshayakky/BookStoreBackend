package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.CustomerDto;
import com.bridgelabz.bookstore.exception.CustomerException;
import com.bridgelabz.bookstore.model.Customer;

public interface ICustomerService {
    Customer addCustomer(CustomerDto customerDto);

    Customer updateCustomer(Long customerId, CustomerDto orderQuantity);

    void removeCustomer(Long customerId) throws CustomerException;

    Customer getCustomer(Long customerId);
}
