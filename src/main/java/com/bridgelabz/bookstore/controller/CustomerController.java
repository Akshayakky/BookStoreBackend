package com.bridgelabz.bookstore.controller;

import com.bridgelabz.bookstore.dto.CustomerDto;
import com.bridgelabz.bookstore.exception.CustomerException;
import com.bridgelabz.bookstore.model.Customer;
import com.bridgelabz.bookstore.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:3000")

public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    /**
     * @param customerDto
     * @return Add customer details to the database
     */
    @PostMapping
    public Customer addCustomer(@RequestBody CustomerDto customerDto) {
        return customerService.addCustomer(customerDto);
    }

    /**
     * @param customerId
     * @param customerDto
     * @return Update customer details of given customer id
     * @throws CustomerException
     */
    @PutMapping("/{customerId}")
    public Customer updateCustomerDetails(@PathVariable long customerId, @RequestBody CustomerDto customerDto) {
        return customerService.updateCustomer(customerId, customerDto);
    }

    /**
     * @param customerId
     * @throws CustomerException
     */
    @DeleteMapping("/{customerId}")
    public void removeCustomer(@PathVariable long customerId) throws CustomerException {
        customerService.removeCustomer(customerId);
    }

    /**
     * @return Customer details of particular customer id
     */
    @GetMapping("/{customerId}")
    public Customer getCustomer(@PathVariable long customerId) {
        return customerService.getCustomer(customerId);
    }
}
