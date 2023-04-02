package com.example.techsavvy.repository;


import com.example.techsavvy.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<Type,Integer> {
    Type findTypeById(int id);
}
