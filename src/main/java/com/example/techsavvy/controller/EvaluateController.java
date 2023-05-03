package com.example.techsavvy.controller;

import com.example.techsavvy.entity.Evaluate;
import com.example.techsavvy.service.EvaluateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/auth/evaluates")
public class EvaluateController {
    private final EvaluateService evaluateService;

    @PostMapping("/createEvaluate")
    public ResponseEntity<Evaluate> createEvaluate(@RequestBody Evaluate evaluate) {
        return ResponseEntity.ok().body(evaluateService.save(evaluate));
    }

    @GetMapping("/getListEvaluateByProduct/{product_id}")
    public ResponseEntity<List<Evaluate>> getListByProduct(@PathVariable("product_id") String product_id) {
        return ResponseEntity.ok().body(evaluateService.getListEvaluateByProduct(product_id));
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Evaluate> getById(@PathVariable("id") int id) {
        return ResponseEntity.ok().body(evaluateService.getById(id));
    }

    @PostMapping("/deleteById/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") int id) {
        return ResponseEntity.ok().body(evaluateService.removeById(id));
    }
}
