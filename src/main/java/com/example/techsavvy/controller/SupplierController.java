package com.example.techsavvy.controller;

import com.example.techsavvy.entity.Supplier;
import com.example.techsavvy.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/suppliers")
public class SupplierController {
    private final SupplierService supplierService;

    @PostMapping("/add")
    public ResponseEntity<Supplier> save(@RequestBody Supplier supplier){
        return ResponseEntity.ok(supplierService.save(supplier));
    }
}
