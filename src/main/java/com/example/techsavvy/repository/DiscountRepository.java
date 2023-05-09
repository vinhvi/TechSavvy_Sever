package com.example.techsavvy.repository;

import com.example.techsavvy.entity.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, String> {
    Discount findDiscountById(String id);
}
