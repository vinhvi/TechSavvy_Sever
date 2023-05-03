package com.example.techsavvy.service;

import com.example.techsavvy.entity.Order;

import java.util.List;

public interface OrderService {

    String randomIdOrder();

    Order createOrder(Order order);

    List<Order> getListOrder();



}
