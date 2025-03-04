package com.example.quizAppJava.controller;

import com.example.quizAppJava.model.Question;
import com.example.quizAppJava.service.QuestionService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("questions")
public class QuestionController {

  @Autowired
  private QuestionService questionService;

//  @GetMapping("csrfToken")
//  public CsrfToken getCsrfToken(HttpServletRequest request) {
//    return (CsrfToken) request.getAttribute("_csrf");
//  }

  @GetMapping
  public ResponseEntity<List<Question>> getAllQuestions() {
    return questionService.getAllQuestions();
  }

  @GetMapping("category/{category}")
  public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category) {
    return questionService.getQuestionsByCategory(category);
  }

  @GetMapping("difficultyLevel")
  public ResponseEntity<List<Question>> getQuestionsByDifficultyLevel(@RequestParam String level) {
    return questionService.getQuestionsByDifficultyLevel(level);
  }

  @PostMapping
  public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
    return questionService.addQuestion(question);
  }
}