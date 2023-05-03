package com.example.techsavvy.repository;

import com.example.techsavvy.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,String> {
    Order findOrderById(String id);

}
