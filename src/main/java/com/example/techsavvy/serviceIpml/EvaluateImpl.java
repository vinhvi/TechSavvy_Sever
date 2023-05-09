package com.example.techsavvy.serviceIpml;

import com.example.techsavvy.entity.Evaluate;
import com.example.techsavvy.repository.EvaluateRepository;
import com.example.techsavvy.service.EvaluateService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class EvaluateImpl implements EvaluateService {
    private final EvaluateRepository evaluateRepository;
    @Override
    public Evaluate save(Evaluate evaluate) {

        return evaluateRepository.save(evaluate);
    }

    @Override
    public Evaluate getById(int id) {
        return evaluateRepository.findEvaluateById(id);
    }

    @Override
    public List<Evaluate> getListEvaluateByProduct(String product_id) {
        return evaluateRepository.findByProductId(product_id);
    }

    @Override
    public void removeById(int id) {
        evaluateRepository.deleteById(id);
    }

}
