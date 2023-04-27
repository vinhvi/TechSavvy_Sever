package com.example.techsavvy.controller;

import com.example.techsavvy.entity.Supplier;
import com.example.techsavvy.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/manage/suppliers")
public class SupplierController {
    private final SupplierService supplierService;

    @PostMapping("/add")
    public ResponseEntity<Supplier> save(@RequestBody Supplier supplier) {
        return ResponseEntity.ok(supplierService.save(supplier));
    }

    @GetMapping("/generateRandomId")
    public ResponseEntity<String> generateIdRandom() {
        return ResponseEntity.ok().body(supplierService.generateId());
    }

    @GetMapping("/getListSupplier")
    public ResponseEntity<List<Supplier>> getListSupplier() {
        return ResponseEntity.ok().body(supplierService.getAll());
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Supplier> getById(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(supplierService.getById(id));
    }

    @GetMapping("/getByPhone/{phone}")
    public ResponseEntity<Supplier> getByPhone(@PathVariable("phone") String phone) {
        return ResponseEntity.ok().body(supplierService.getByPhone(phone));
    }
}
