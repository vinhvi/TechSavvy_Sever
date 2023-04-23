package com.example.techsavvy.repository;

import com.example.techsavvy.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier,String> {
    Supplier findSupplierById(String id);
    Supplier findByEmail(String email);
    Supplier findByPhone(String phone);
}
