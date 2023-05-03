package com.example.techsavvy.repository;

import com.example.techsavvy.entity.Evaluate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluateRepository extends JpaRepository<Evaluate,Integer> {
    Evaluate findEvaluateById(int id);
    List<Evaluate> findByProductId(String product_id);
    boolean deleteById(int id);
}
