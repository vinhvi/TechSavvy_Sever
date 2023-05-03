package com.example.techsavvy.repository;


import com.example.techsavvy.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,String> {
    Customer findCustomerById(String id);
    Customer findByPhone(String phone);
    Customer findCustomerByEmail(String email);
}
