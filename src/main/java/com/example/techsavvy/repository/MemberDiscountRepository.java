package com.example.techsavvy.repository;

import com.example.techsavvy.entity.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberDiscountRepository extends JpaRepository<Voucher,Integer> {
}
