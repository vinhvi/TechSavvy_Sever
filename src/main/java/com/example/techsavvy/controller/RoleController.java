package com.example.techsavvy.controller;

import com.example.techsavvy.entity.Role;
import com.example.techsavvy.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/role")
public class RoleController {
    private final RoleService roleService;

    @PostMapping("/create")
    public ResponseEntity<Role> create(@RequestBody Role role) {
        return ResponseEntity.ok().body(roleService.createRole(role));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> getById(@PathVariable("id") int id) {
        return ResponseEntity.ok().body(roleService.getById(id));
    }

    @GetMapping("/getByName")
    public ResponseEntity<Role> getByName(@RequestParam("name") String name){
        return ResponseEntity.ok().body(roleService.getByName(name));
    }
    @GetMapping("/getList")
    public ResponseEntity<List<Role>> getAll(){
        return ResponseEntity.ok().body(roleService.getAll());
    }
}
