package com.example.techsavvy.service;

import com.example.techsavvy.entity.Question;

import java.util.List;

public interface QuestionService {
    Question createQuestion(Question newQuestion);
    Question updateQuestion(int id);
    List<Question> getQuestionByProduct(String product_id);

    Question getById(int id);
    List<Question> getListQuestionByReply();
}
