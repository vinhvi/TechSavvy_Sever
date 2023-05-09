package com.example.techsavvy.serviceIpml;

import com.example.techsavvy.entity.Answer;
import com.example.techsavvy.repository.AnswerRepository;
import com.example.techsavvy.service.AnswerService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AnswerImpl implements AnswerService {
    private final AnswerRepository answerRepository;

    @Override
    public Answer createAnswer(Answer newAnswer) {
        Date date = new Date();
        newAnswer.setReplyDate(date);
        return answerRepository.save(newAnswer);
    }

    @Override
    public Answer getById(int id) {
        return answerRepository.findAnswerById(id);
    }

    @Override
    public void deleteAnswer(int id) {
        answerRepository.deleteById(id);
    }

    @Override
    public Answer updateAnswer(Answer newAnswer) {
        Answer answerUpdate = answerRepository.findAnswerById(newAnswer.getId());
        if (answerUpdate == null) {
            throw new RuntimeException("Câu trả lời không tồn tại!!");
        } else {
            answerUpdate.setContent(newAnswer.getContent());
        }
        return answerRepository.save(answerUpdate);
    }

    @Override
    public List<Answer> getAnswerByQuestion(int id) {
        return answerRepository.findAnswerByQuestionId(id);
    }

    @Override
    public List<Answer> getAnswerByQuestionAndProductId(String product_id) {
        return answerRepository.findAnswerByQuestion_ProductId(product_id);
    }
}
