package com.example.techsavvy.service;

import com.example.techsavvy.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);
    Employee getOneEmployee(Employee employee);
    Employee getById(int id);

    List<Employee> getAll();

    void addRoleToEmployee(String email,String roleName);
}
