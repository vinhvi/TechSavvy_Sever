package com.example.techsavvy.repository;


import com.example.techsavvy.entity.Product;
import com.example.techsavvy.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findProductById(int id);
    List<Product> findByType(Type type);
}
