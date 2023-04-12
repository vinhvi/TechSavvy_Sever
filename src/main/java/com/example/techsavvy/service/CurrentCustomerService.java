package com.example.techsavvy.service;

import com.example.techsavvy.entity.CurrentCustomer;

import java.util.List;

public interface CurrentCustomerService {
    CurrentCustomer create(CurrentCustomer currentCustomer);

    List<CurrentCustomer> getAll();

    CurrentCustomer getOne(CurrentCustomer currentCustomer);

    CurrentCustomer getById(int id);

    CurrentCustomer getByEmail(String email);
    CurrentCustomer getByPhone(String phone);
}
