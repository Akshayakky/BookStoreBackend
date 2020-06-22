package com.bridgelabz.bookstore.controller;

import com.bridgelabz.bookstore.dto.CustomerDto;
import com.bridgelabz.bookstore.exception.CustomerException;
import com.bridgelabz.bookstore.model.Customer;
import com.bridgelabz.bookstore.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    /**
     * @param customerDto - Shipping details for customer
     * @return Add customer details to the database
     */
    @PostMapping
    public Customer addCustomer(@RequestBody CustomerDto customerDto) {
        return customerService.addCustomer(customerDto);
    }

    /**
     * @param customerId  - CustomerId to update
     * @param customerDto - Updated shipping details
     * @return Update customer details of given customer id
     * @throws CustomerException
     */
    @PutMapping("/{customerId}")
    public Customer updateCustomerDetails(@PathVariable Long customerId, @RequestBody CustomerDto customerDto) {
        return customerService.updateCustomer(customerId, customerDto);
    }

    /**
     * @param customerId - Id to remove customer details
     * @throws CustomerException
     */
    @DeleteMapping("/{customer-id}")
    public void removeCustomer(@PathVariable(value = "customer-id") Long customerId) throws CustomerException {
        customerService.removeCustomer(customerId);
    }

    /**
     * @return Customer details of particular customer id
     */
    @GetMapping("/{customer-id}")
    public Customer getCustomer(@PathVariable(value = "customer-id") Long customerId) {
        return customerService.getCustomer(customerId);
    }
}
