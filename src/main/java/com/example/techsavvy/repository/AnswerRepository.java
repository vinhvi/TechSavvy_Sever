package com.example.techsavvy.repository;

import com.example.techsavvy.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {
    Answer findAnswerById(int id);

    List<Answer> findAnswerByQuestionId(int id);
    List<Answer> findAnswerByQuestion_ProductId(String id);
}
