package com.example.techsavvy.serviceIpml;

import com.example.techsavvy.entity.Order;
import com.example.techsavvy.repository.OptionsRepository;
import com.example.techsavvy.repository.OrderRepository;
import com.example.techsavvy.service.OrderService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class OrderImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public String randomIdOrder() {
        Random random = new Random();
        String idOrder = "";
        boolean check = false;
        int attempts = 0;
        int maxAttempts = 10000; // set a maximum number of attempts to prevent infinite loop
        while (!check && attempts < maxAttempts) {
            int number = random.nextInt(10000);
            idOrder = "HDBH" + String.format("%04d", number);
            if (orderRepository.findOrderById(idOrder) == null) {
                check = true;
            }
            attempts++;
        }
        if (!check) {
            throw new RuntimeException("Unable to generate a unique ID after " + maxAttempts + " attempts.");
        }
        return idOrder;
    }

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getListOrder() {
        return orderRepository.findAll();
    }
}
