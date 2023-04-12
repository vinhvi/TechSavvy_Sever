package com.example.techsavvy.repository;

import com.example.techsavvy.entity.ShippingCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingCompanyRepository extends JpaRepository<ShippingCompany,Integer> {
    ShippingCompany findById(int id);
    ShippingCompany findByPhoneOrEmail(String phone, String email);
    ShippingCompany findByPhone(String phone);
    ShippingCompany findByEmail(String email);
}
