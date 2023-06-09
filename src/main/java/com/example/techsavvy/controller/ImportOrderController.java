package com.example.techsavvy.controller;

import com.example.techsavvy.entity.ImportOrder;
import com.example.techsavvy.entity.ImportOrderDetail;
import com.example.techsavvy.service.ImportDetailService;
import com.example.techsavvy.service.ImportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/manage/importOrders")
public class ImportOrderController {
    private final ImportService importService;
    private final ImportDetailService importDetailService;

    @PostMapping("/createImport")
    public ResponseEntity<ImportOrder> create(@RequestBody ImportOrder importOrder) {
        return ResponseEntity.ok(importService.save(importOrder));
    }

    @PostMapping("/createImportDetail")
    public ResponseEntity<ImportOrderDetail> createDetail(@RequestBody ImportOrderDetail importOrderDetail) {
        return ResponseEntity.ok(importDetailService.save(importOrderDetail));
    }

    @GetMapping("/getImportOrderDetailByImportOrderId/{id}")
    public ResponseEntity<List<ImportOrderDetail>> getByImportOrderId(@PathVariable("id") String id) {
        return ResponseEntity.ok(importDetailService.getListByImportOrderId(id));
    }

    @GetMapping("/getAllImportOrder")
    public ResponseEntity<List<ImportOrder>> getAll() {
        return ResponseEntity.ok().body(importService.getAllImportOrder());
    }

    @GetMapping("generateRandomId")
    public ResponseEntity<String> getRandomIdImportOrder() {
        return ResponseEntity.ok().body(importService.generateId());
    }
}
