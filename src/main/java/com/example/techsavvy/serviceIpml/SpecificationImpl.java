package com.example.techsavvy.serviceIpml;

import com.example.techsavvy.entity.Specification;
import com.example.techsavvy.repository.SpecificationRepository;
import com.example.techsavvy.service.SpecificationService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class SpecificationImpl implements SpecificationService {

    private final SpecificationRepository specificationRepository;


    @Override
    public Specification formatSpecification(Specification specification) {
        return null;
    }

    @Override
    public Specification saveSpecification(Specification specification) {
        return specificationRepository.save(specification);
    }

    @Override
    public Specification getOneSpecification(Specification specification) {
        return null;
    }

    @Override
    public List<Specification> getListSpecification(List<Specification> specifications) {
        return null;
    }

    @Override
    public List<Specification> saveListSpecification(List<Specification> specifications) {
        return null;
    }
}
