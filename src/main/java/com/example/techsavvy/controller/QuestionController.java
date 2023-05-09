package com.example.techsavvy.controller;

import com.example.techsavvy.entity.Question;
import com.example.techsavvy.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/question")
public class QuestionController {

    private final QuestionService questionService;

    @PostMapping("/createQuestion")
    public ResponseEntity<Question> createQuestion(@RequestBody Question newQuestion) {
        return ResponseEntity.ok().body(questionService.createQuestion(newQuestion));
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Question> getQuestionId(@PathVariable("id") int id) {
        return ResponseEntity.ok().body(questionService.getById(id));
    }

    @GetMapping("/getQuestionByProduct_id/{product_id}")
    public ResponseEntity<?> getQuestionByProduct(@PathVariable("product_id") String product_id) {
        List<Question> questionList = questionService.getQuestionByProduct(product_id);
        if (questionList.isEmpty()) {
            return ResponseEntity.status(402).body("Sản phẩm chưa có câu hỏi!!");
        } else {
            return ResponseEntity.ok().body(questionList);
        }
    }

//    public ResponseEntity<?> updateQuestion();

    @GetMapping("/getQuestionByReply")
    public ResponseEntity<?> getQuestionByReply(){
        List<Question> questions = questionService.getListQuestionByReply();
        if (questions.isEmpty()) {
            return ResponseEntity.status(405).body("Chưa có câu hỏi nào!!");
        } else {
            return ResponseEntity.ok().body(questions);
        }
    }
}
