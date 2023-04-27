package com.example.techsavvy.repository;

import com.example.techsavvy.entity.Product;
import com.example.techsavvy.entity.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecificationRepository extends JpaRepository<Specification,Integer> {
    List<Specification> findSpecificationByProductId(String productId);

    Specification findSpecificationById(int id);
}
