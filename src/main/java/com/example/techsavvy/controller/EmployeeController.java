package com.example.techsavvy.controller;

import com.example.techsavvy.entity.Employee;
import com.example.techsavvy.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/manage")
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping("/admin/employee/create")
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        return ResponseEntity.ok().body(employeeService.createEmployee(employee));
    }

    @PostMapping("/employee/update")
    public ResponseEntity<Employee> update(@RequestBody Employee employee){
        return ResponseEntity.ok().body(employeeService.updateEmployee(employee));
    }

    @GetMapping("admin/employee/getRandomId")
    public ResponseEntity<String> getRandomId(){
        return ResponseEntity.ok().body(employeeService.generateId());
    }

    @GetMapping("/employee/getById/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") String id){
        return  ResponseEntity.ok().body(employeeService.getById(id));
    }

    @GetMapping("/employee/getListEmployee")
    public  ResponseEntity<List<Employee>> getListEmployee(){
        return ResponseEntity.ok().body(employeeService.getAll());
    }
    @GetMapping("/employee/getByEmail/{email}")
    public ResponseEntity<Employee> getByEmail(@PathVariable("email") String email){
        return ResponseEntity.ok().body(employeeService.getByEmail(email));
    }
}
