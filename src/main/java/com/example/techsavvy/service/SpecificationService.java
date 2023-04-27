package com.example.techsavvy.service;

import com.example.techsavvy.entity.Product;
import com.example.techsavvy.entity.Specification;

import java.util.List;

public interface SpecificationService {

    Specification saveSpecification(Specification specification);

    void deleteById(int id);

    List<Specification> getByProduct(String productId);


}
