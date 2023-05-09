package com.example.techsavvy.controller;

import com.example.techsavvy.entity.Discount;
import com.example.techsavvy.service.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/discounts")
public class DiscountController {

    private final DiscountService discountService;

    @PostMapping("/createDiscount")
    public ResponseEntity<Discount> createDiscount(@RequestBody Discount discount) {
        return ResponseEntity.ok().body(discountService.createDiscount(discount));
    }

    @GetMapping("/randomId")
    public ResponseEntity<String> getRandomId() {
        return ResponseEntity.ok().body(discountService.randomIdDiscount());
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Discount> getDiscountById(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(discountService.getById(id));
    }

    @GetMapping("/getListDiscount")
    public ResponseEntity<List<Discount>> getListDiscount() {
        return ResponseEntity.ok().body(discountService.getListDiscount());
    }
}
