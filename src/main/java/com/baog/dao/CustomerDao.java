package com.baog.dao;

import com.baog.dto.CustomerDto;
import com.baog.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDao {

    Customer saveCustomer(String firstName, String lastName, String email);

    void saveCustomer1(String firstName, String lastName, String email);

    Customer saveCustomer(CustomerDto customerDto);


    Optional<Customer> getCustomerById(long customerId);


    List<Customer> getAllCustomers();


}
