package com.example.techsavvy.repository;

import com.example.techsavvy.entity.Options;
import com.example.techsavvy.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OptionsRepository extends JpaRepository<Options, Integer> {
    Options findOptionsById(int id);
    List<Options> findOptionsByProductId(String id);

}
