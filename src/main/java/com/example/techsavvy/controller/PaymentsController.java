package com.example.techsavvy.controller;

import com.example.techsavvy.entity.Payments;
import com.example.techsavvy.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/auth/payments")
public class PaymentsController {

    private final PaymentService paymentService;

    @PostMapping("/add")
    public ResponseEntity<Payments> addPayments(@RequestBody Payments payments) {
        return ResponseEntity.ok().body(paymentService.add(payments));
    }

    @GetMapping("/getListPayments")
    public ResponseEntity<List<Payments>> getListPayments() {
        return ResponseEntity.ok().body(paymentService.getListPayments());
    }
}
