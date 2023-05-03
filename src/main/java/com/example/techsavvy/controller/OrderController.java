package com.example.techsavvy.controller;

import com.example.techsavvy.entity.Customer;
import com.example.techsavvy.entity.Order;
import com.example.techsavvy.entity.OrderDetail;
import com.example.techsavvy.service.OrderDetailService;
import com.example.techsavvy.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/auth/order")
public class OrderController {

    private final OrderService orderService;
    private final OrderDetailService orderDetailService;

    @GetMapping("/getRandomIdOrder")
    public ResponseEntity<String> getIdRandom() {
        return ResponseEntity.ok().body(orderService.randomIdOrder());
    }

    @PostMapping("/createOrder")
    public ResponseEntity<Order> creatOrder(@RequestBody Order order) {
        return ResponseEntity.ok().body(orderService.createOrder(order));
    }

    @PostMapping("/createOrderDetail")
    public ResponseEntity<OrderDetail> createOrderDetail(@RequestBody OrderDetail orderDetail) {
        return ResponseEntity.ok().body(orderDetailService.create(orderDetail));
    }

    @GetMapping("/getListOrder")
    public ResponseEntity<?> getListOrder() {
        List<Order> orderList = orderService.getListOrder();
        if (orderList != null) {
            return ResponseEntity.ok().body(orderList);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lỗi Server !!");
        }
    }

    @GetMapping("/getByOrder/{order_id}")
    public ResponseEntity<List<OrderDetail>> getByOrder(@PathVariable("order_id") String order_id) {
        return ResponseEntity.ok().body(orderDetailService.getByOrder(order_id));
    }
}
