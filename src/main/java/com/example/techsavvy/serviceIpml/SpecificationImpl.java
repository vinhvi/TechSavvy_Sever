package com.example.techsavvy.serviceIpml;

import com.example.techsavvy.entity.Product;
import com.example.techsavvy.entity.Specification;
import com.example.techsavvy.repository.SpecificationRepository;
import com.example.techsavvy.service.SpecificationService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class SpecificationImpl implements SpecificationService {

    private final SpecificationRepository specificationRepository;

    @Override
    public Specification saveSpecification(Specification specification) {
        Specification existingSpecification = specificationRepository.findSpecificationById(specification.getId());
        if (existingSpecification != null) {
            // Update the existing specification
            existingSpecification.setDescribes(specification.getDescribes());
            existingSpecification.setName(specification.getName());
            return specificationRepository.save(existingSpecification);
        } else {
            // Save a new specification
            System.out.println(specification);
            return specificationRepository.save(specification);
        }
    }


    @Override
    public void deleteById(int id) {
        specificationRepository.deleteById(id);
    }

    @Override
    public List<Specification> getByProduct(String productId) {
        return specificationRepository.findSpecificationByProductId(productId);
    }

}
