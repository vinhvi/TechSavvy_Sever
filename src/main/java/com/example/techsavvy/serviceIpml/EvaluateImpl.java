package com.example.techsavvy.serviceIpml;

import com.example.techsavvy.entity.Evaluate;
import com.example.techsavvy.repository.EmployeeRepository;
import com.example.techsavvy.repository.EvaluateRepository;
import com.example.techsavvy.service.EvaluateService;
import com.example.techsavvy.service.MemberService;
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
    private final MemberService memberService;

    @Override
    public Evaluate save(Evaluate evaluate) {
        Evaluate evaluate1 = new Evaluate();
        evaluate1.setContent(evaluate.getContent());
        evaluate1.setValue(evaluate.getValue());
        return evaluateRepository.save(evaluate1);
    }

    @Override
    public Evaluate getById(int id) {
        return null;
    }

    @Override
    public Evaluate getOne(Evaluate evaluate) {
        Evaluate evaluate1 = new Evaluate();
        evaluate1 = getOne(evaluate);

        return evaluate1;
    }

    @Override
    public List<Evaluate> getListEvaluate(List<Evaluate> evaluates) {
        return null;
    }

    @Override
    public Evaluate fromatEvaluate(Evaluate evaluate) {
        Evaluate evaluate1 = new Evaluate();
        evaluate1.setId(evaluate.getId());
        evaluate1.setValue(evaluate.getValue());
        evaluate1.setContent(evaluate.getContent());
        return evaluate1;
    }
}
