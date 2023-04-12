package com.example.techsavvy.controller;

import com.example.techsavvy.entity.Type;
import com.example.techsavvy.service.TypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/types")
public class TypeController {
    private final TypeService typeService;

    @PostMapping("/save")
    public ResponseEntity<Type> saveType(@RequestBody Type type) {
        Type savedType = typeService.saveType(type);
        return ResponseEntity.ok(savedType);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Type> getById(@PathVariable("id") int id) {
        return ResponseEntity.ok().body(typeService.getTypeById(id));
    }

    @GetMapping("/getByProduct/{id}")
    public ResponseEntity<Type> getByProduct(@PathVariable("id") int id) {
        return ResponseEntity.ok().body(typeService.getOneType(id));
    }
}
