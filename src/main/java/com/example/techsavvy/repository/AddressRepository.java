package com.example.techsavvy.repository;

import com.example.techsavvy.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AddressRepository extends JpaRepository<Address, Integer> {
    Address findById(int id);
}
