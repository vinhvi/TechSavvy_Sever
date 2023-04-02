package com.example.techsavvy.service;

import com.example.techsavvy.entity.Employee;

import java.util.List;

public interface EmployeeService {
    String createEmployee(Employee employee,String password);
    Employee getOneEmployee(Employee employee);
    Employee getById(int id);

    List<Employee> getAll();
}
