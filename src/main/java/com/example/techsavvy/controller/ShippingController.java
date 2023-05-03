package com.example.techsavvy.controller;

import com.example.techsavvy.entity.ShippingCompany;
import com.example.techsavvy.service.ShippingCompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/shipping-company")
public class ShippingController {

    private final ShippingCompanyService shippingCompanyService;

    @PostMapping("/add")
    public ResponseEntity<ShippingCompany> add(@RequestBody ShippingCompany shippingCompany) {
        return ResponseEntity.ok().body(shippingCompanyService.add(shippingCompany));
    }

    @GetMapping("/getByPhoneOrEmail/{value}")
    public ResponseEntity<?> getByEmailOrPhone(@PathVariable("value") String value) {
        ShippingCompany shippingCompany = shippingCompanyService.getByEmailOrPhone(value);
        if (shippingCompany != null) {
            return ResponseEntity.ok(shippingCompany);
        }
        return ResponseEntity.status(400).body("Không tìm thấy !!");
    }

    @GetMapping("/getAllShippingCompany")
    public ResponseEntity<?> getListShippingCompany(){
        List<ShippingCompany> shippingCompanies = shippingCompanyService.getList();
        if (shippingCompanies != null) {
            return ResponseEntity.ok(shippingCompanies);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lỗi Server!!");
    }
}

