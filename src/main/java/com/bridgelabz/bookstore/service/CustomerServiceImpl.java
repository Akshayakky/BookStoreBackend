package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.CustomerDto;
import com.bridgelabz.bookstore.exception.CustomerException;
import com.bridgelabz.bookstore.model.Customer;
import com.bridgelabz.bookstore.repository.ICustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * @param customerDto - Customer details
     * @return Add customer details to the database
     */
    @Override
    public Customer addCustomer(CustomerDto customerDto) {
        Customer customer = modelMapper.map(customerDto, Customer.class);
        return customerRepository.save(customer);
    }

    /**
     * @param customerId  - Id to update customer details
     * @param customerDto - updated customer details
     * @return Update customer details of given customer id
     */
    @Override
    public Customer updateCustomer(Long customerId, CustomerDto customerDto) {
        Customer customer = modelMapper.map(customerDto, Customer.class);
        customer.setCustomerId(customerId);
        return customerRepository.save(customer);
    }

    /**
     * @param customerId - Id to remove customer details
     * @throws CustomerException
     */
    @Override
    public void removeCustomer(Long customerId) throws CustomerException {
        if (customerRepository.findById(customerId).isPresent())
            customerRepository.deleteById(customerId);
        else throw new CustomerException(CustomerException.ExceptionType.CUSTOMER_NOT_FOUND, "CUSTOMER_NOT_FOUND");
    }

    /**
     * @param customerId - Id to get customer details
     * @return - Customer details
     */
    @Override
    public Customer getCustomer(Long customerId) {
        return customerRepository.findById(customerId).get();
    }
}
