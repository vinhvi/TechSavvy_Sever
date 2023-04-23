package com.example.techsavvy.repository;

import com.example.techsavvy.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,String> {
    Employee findEmployeeById(String id);

    Employee findEmployeeByEmail(String email);
}
