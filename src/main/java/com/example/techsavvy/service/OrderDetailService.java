package com.example.techsavvy.service;

import com.example.techsavvy.entity.Order;
import com.example.techsavvy.entity.OrderDetail;

import java.util.List;

public interface OrderDetailService {
   OrderDetail create(OrderDetail orderDetail);

   List<OrderDetail> getByOrder(String order_id);
}
