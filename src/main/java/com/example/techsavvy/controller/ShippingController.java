package com.example.techsavvy.controller;

import com.example.techsavvy.entity.ShippingCompany;
import com.example.techsavvy.service.ShippingCompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/shipping-company")
public class ShippingController {

    private final ShippingCompanyService shippingCompanyService;

    @PostMapping("/add")
    public ResponseEntity<ShippingCompany> add(@RequestBody ShippingCompany shippingCompany) {
        return ResponseEntity.ok().body(shippingCompanyService.add(shippingCompany));
    }

    @GetMapping("/getByPhoneOrEmail")
    public ResponseEntity<?> getByEmailOrPhone(@RequestParam String value) {
        try {
            ShippingCompany shippingCompany = shippingCompanyService.getByEmailOrPhone(value);
            return ResponseEntity.ok(shippingCompany);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }
}
