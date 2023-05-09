package com.example.techsavvy.controller;

import com.example.techsavvy.entity.Answer;
import com.example.techsavvy.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/answer")
public class AnswerController {
    private final AnswerService answerService;

    @PostMapping("/createAnswer")
    public ResponseEntity<Answer> createAnswer(@RequestBody Answer newAnswer) {
        return ResponseEntity.ok().body(answerService.createAnswer(newAnswer));
    }

    @DeleteMapping("deleteAnswer/{id}")
    public ResponseEntity<?> deleteAnswer(@PathVariable("id") int id) {
        Answer answer = answerService.getById(id);
        if (answer == null) {
            return ResponseEntity.status(402).body("Câu trả lời không tồn tại!!");
        } else {
            answerService.deleteAnswer(id);
            return ResponseEntity.ok().body("Xóa thành công !!");
        }
    }

    @GetMapping("getAnswerByQuestion/{id}")
    public ResponseEntity<?> getAnswerByQuestion(@PathVariable("id") int id) {
        List<Answer> answerList = answerService.getAnswerByQuestion(id);
        if (answerList.isEmpty()) {
            return ResponseEntity.status(402).body("Câu hỏi chưa có câu trả lời");
        } else {
            return ResponseEntity.ok().body(answerList);
        }
    }

    @GetMapping("getAnswerByQuestionAndProductId/{product_id}")
    public ResponseEntity<?> getAnswerByQuestionAndProductId(@PathVariable("product_id") String product_id) {
        List<Answer> answerList = answerService.getAnswerByQuestionAndProductId(product_id);
        if (answerList.isEmpty()) {
            return ResponseEntity.status(406).body("Câu hỏi của sản phẩm không tồn tại");
        } else {
            return ResponseEntity.ok().body(answerList);
        }
    }
}
