package com.example.techsavvy.controller;

import com.example.techsavvy.entity.Options;
import com.example.techsavvy.entity.Product;
import com.example.techsavvy.service.OptionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/manage/optionProduct")
public class OptionsController {

    private final OptionsService optionsService;

    @PostMapping("/save")
    public ResponseEntity<Boolean> saveOptions(@RequestBody Options options) {
        Options options1 = optionsService.save(options);
        if (options1 != null) {
            return ResponseEntity.ok().body(true);
        } else {
            return ResponseEntity.badRequest().body(false);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<Boolean> update(@RequestBody Options options) {
        Options options1 = optionsService.updateOptions(options);
        if (options1 != null) {
            System.out.println("Options after update: " + options1);
            return ResponseEntity.ok().body(true);
        } else {
            return ResponseEntity.badRequest().body(false);
        }
    }

    @GetMapping("/getByProduct/{productId}")
    public ResponseEntity<List<Options>> getOptionsByProduct(@PathVariable("productId") String productId) {
        return ResponseEntity.ok().body(optionsService.getOptionsByProduct(productId));
    }

    @GetMapping("/getByDiscount/{id_discount}")
    public ResponseEntity<List<Options>> getListOptionsByDiscountId(@PathVariable("id_discount") String id) {
        return ResponseEntity.ok().body(optionsService.getListOptionsByDiscountId(id));
    }
}
