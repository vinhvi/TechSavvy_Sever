package com.example.techsavvy.serviceIpml;

import com.example.techsavvy.entity.OrderDetail;
import com.example.techsavvy.repository.OrderDetailRepository;
import com.example.techsavvy.service.OrderDetailService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class OrderDetailIplm implements OrderDetailService {
    private final OrderDetailRepository orderDetailRepository;

    @Override
    public OrderDetail create(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    @Override
    public List<OrderDetail> getByOrder(String order_id) {
        return orderDetailRepository.findByOrderId(order_id);
    }
}
