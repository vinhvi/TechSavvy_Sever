package com.example.techsavvy.repository;


import com.example.techsavvy.entity.Product;
import com.example.techsavvy.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,String> {
    Product findProductById(String id);
    List<Product> findByType(Type type);

    Product findProductByLo(String lo);

    List<Product> findAllByName(String name);

    Product findProductByName(String  key);
}
