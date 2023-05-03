package com.example.techsavvy.service;


import com.example.techsavvy.entity.Customer;

import java.text.ParseException;
import java.util.List;

public interface CustomerService {
    Customer addCustomer(Customer customer) ;

    Customer getById(String id);

    List<Customer> getAll();
    Customer getByEmail(String email);

    Customer getByPhone(String phone);

    String randomId();

}
