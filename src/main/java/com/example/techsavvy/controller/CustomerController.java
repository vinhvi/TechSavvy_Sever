package com.example.techsavvy.controller;

import com.example.techsavvy.entity.Customer;
import com.example.techsavvy.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/customer")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/add")
    public ResponseEntity<Customer> addMember(@RequestBody Customer customer) {
        return ResponseEntity.ok().body(customerService.addCustomer(customer));
    }

    @GetMapping("/getByPhone/{phone}")
    public ResponseEntity<?> getByPhone(@PathVariable("phone") String phone) {
        Customer customer = customerService.getByPhone(phone);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        }
        return ResponseEntity.status(400).body("Không Tìm Thấy !!");
    }

    @GetMapping("/randomId")
    public ResponseEntity<String> randomIdCustomer() {
        return ResponseEntity.ok().body(customerService.randomId());
    }

    @GetMapping("/getListCustomer")
    public ResponseEntity<?> getListCustomer() {
        List<Customer> customerList = customerService.getAll();
        if (customerList != null) {
            return ResponseEntity.ok().body(customerList);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lỗi Server !!");
        }
    }

    @GetMapping("/getByEmail/{email}")
    public ResponseEntity<?> getByEmail(@PathVariable("email") String email) {
        Customer customer = customerService.getByEmail(email);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        }
        return ResponseEntity.status(400).body("Không Tìm Thấy !!");
    }

}
