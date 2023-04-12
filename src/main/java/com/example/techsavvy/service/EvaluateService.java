package com.example.techsavvy.service;

import com.example.techsavvy.entity.Evaluate;

import java.util.List;

public interface EvaluateService {
    Evaluate save(Evaluate evaluate);

    Evaluate getById(int id);

    Evaluate getOne(Evaluate evaluate);

    List<Evaluate> getListEvaluate(List<Evaluate> evaluates);
    Evaluate fromatEvaluate(Evaluate evaluate);
}
