package com.example.techsavvy.service;

import com.example.techsavvy.entity.Answer;

import java.util.List;

public interface AnswerService {
    Answer createAnswer(Answer newAnswer);

    Answer getById(int id);

    void deleteAnswer(int id);

    Answer updateAnswer(Answer newAnswer);

    List<Answer> getAnswerByQuestion(int id);

    List<Answer> getAnswerByQuestionAndProductId(String product_id);
}
