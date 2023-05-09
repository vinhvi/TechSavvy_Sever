package com.example.techsavvy.serviceIpml;

import com.example.techsavvy.entity.Question;
import com.example.techsavvy.repository.QuestionRepository;
import com.example.techsavvy.service.QuestionService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class QuestionImpl implements QuestionService {
    private final QuestionRepository questionRepository;

    @Override
    public Question createQuestion(Question newQuestion) {
        return questionRepository.save(newQuestion);
    }

    @Override
    public Question updateQuestion(int id) {
        Question questionUpdate = questionRepository.findQuestionById(id);
        questionUpdate.setReply(true);
        return questionUpdate;
    }

    @Override
    public List<Question> getQuestionByProduct(String product_id) {
        return questionRepository.findQuestionByProductId(product_id);
    }

    @Override
    public Question getById(int id) {
        return questionRepository.findQuestionById(id);
    }

    @Override
    public List<Question> getListQuestionByReply() {
        List<Question> questionList = questionRepository.findAll();
        List<Question> questions = new ArrayList<>();
        for (Question question : questionList) {
            boolean reply = question.isReply();
            if (!reply) {
                questions.add(question);
            }
        }
        return questions;
    }
}
