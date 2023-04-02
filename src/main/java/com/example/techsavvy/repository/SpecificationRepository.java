package com.example.techsavvy.repository;

import com.example.techsavvy.entity.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecificationRepository extends JpaRepository<Specification,Integer> {
}
