package com.example.techsavvy.service;

import com.example.techsavvy.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);
    Employee getOneEmployee(Employee employee);
    Employee getById(String id);
    Employee getByEmail(String email);
    List<Employee> getAll();
    Employee updateEmployee(Employee employee);
    String generateId();

}
