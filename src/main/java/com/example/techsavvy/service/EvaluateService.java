package com.example.techsavvy.service;

import com.example.techsavvy.entity.Evaluate;

import java.util.List;

public interface EvaluateService {
    Evaluate save(Evaluate evaluate);
    Evaluate getById(int id);
    List<Evaluate> getListEvaluateByProduct(String product_id);

    boolean removeById(int id);

}
