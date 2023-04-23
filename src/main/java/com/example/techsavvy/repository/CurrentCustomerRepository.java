package com.example.techsavvy.repository;

import com.example.techsavvy.entity.CurrentCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrentCustomerRepository extends JpaRepository<CurrentCustomer, String> {
//    CurrentCustomer findById(String id);
    CurrentCustomer findByEmail(String email);
    CurrentCustomer findByPhone(String phone);
}
