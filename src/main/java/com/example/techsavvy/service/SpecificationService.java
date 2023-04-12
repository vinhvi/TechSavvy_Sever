package com.example.techsavvy.service;

import com.example.techsavvy.entity.Specification;

import java.util.List;

public interface SpecificationService {

    Specification formatSpecification(Specification specification);

    Specification saveSpecification(Specification specification);

    Specification getOneSpecification(Specification specification);

    List<Specification> getListSpecification(List<Specification> specifications);

    List<Specification> saveListSpecification(List<Specification> specifications);

}
