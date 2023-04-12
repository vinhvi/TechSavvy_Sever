package com.example.techsavvy.repository;

import com.example.techsavvy.entity.CurrentCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrentCustomerRepository extends JpaRepository<CurrentCustomer, Integer> {
    CurrentCustomer findById(int id);
    CurrentCustomer findByEmail(String email);
    CurrentCustomer findByPhone(String phone);
}
