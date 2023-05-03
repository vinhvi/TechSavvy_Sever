package com.example.techsavvy.repository;

import com.example.techsavvy.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail,Integer> {

    List<OrderDetail> findByOrderId(String id);

}
