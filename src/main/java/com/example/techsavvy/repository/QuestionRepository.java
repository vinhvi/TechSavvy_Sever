package com.example.techsavvy.repository;

import com.example.techsavvy.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    Question findQuestionById(int id);
    List<Question> findQuestionByProductId(String product_id);

}
