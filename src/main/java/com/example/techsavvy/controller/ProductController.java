package com.example.techsavvy.controller;

import com.example.techsavvy.entity.Evaluate;
import com.example.techsavvy.entity.Options;
import com.example.techsavvy.entity.Product;
import com.example.techsavvy.entity.Specification;
import com.example.techsavvy.service.EvaluateService;
import com.example.techsavvy.service.OptionsService;
import com.example.techsavvy.service.ProductService;
import com.example.techsavvy.service.SpecificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/manage/products")
public class ProductController {
    private final ProductService productService;
    private final OptionsService optionsService;

    private final SpecificationService specificationService;

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.saveProduct(product));
    }

    @PostMapping("/addOptions")
    public ResponseEntity<Options> addOptions(@RequestBody Options options) {
        return ResponseEntity.ok().body(optionsService.save(options));
    }

    @GetMapping("/generateIdProduct")
    public ResponseEntity<String> getRandomIdProduct() {
        return ResponseEntity.ok().body(productService.generateIdProduct());
    }

    @GetMapping("/generateLH")
    public ResponseEntity<String> getRandomLH() {
        return ResponseEntity.ok().body(productService.generateLoHang());
    }

    @GetMapping("/getAllProduct")
    public ResponseEntity<List<Product>> getListProduct() {
        return ResponseEntity.ok().body(productService.getAllProducts());
    }

    @GetMapping("/getSpecifiByProduct/{productId}")
    public ResponseEntity<List<Specification>> getSpecifiByProduct(@PathVariable("productId") String productId) {
        return ResponseEntity.ok().body(specificationService.getByProduct(productId));
    }

    @PostMapping("/createSpecification")
    public ResponseEntity<Boolean> createSpecifi(@RequestBody Specification specification) {
        Specification specification1 = specificationService.saveSpecification(specification);
        if (specification1 != null) {
            return ResponseEntity.ok().body(true);
        } else {
            return ResponseEntity.badRequest().body(false);
        }
    }

    @GetMapping("/getByIdOrName/{key}")
    public ResponseEntity<List<Product>> getByIdOrName(@PathVariable("key") String key) {
        String value = key.replace("+", " ");
        System.out.println(value);
        return ResponseEntity.ok().body(productService.getByIdOrName(value));
    }

    @GetMapping("/getProductById/{id}")
    public ResponseEntity<Product> getById(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(productService.getProductById(id));
    }


}
