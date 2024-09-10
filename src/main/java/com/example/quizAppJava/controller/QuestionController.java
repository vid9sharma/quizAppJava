package com.example.quizAppJava.controller;

import com.example.quizAppJava.model.Question;
import com.example.quizAppJava.service.QuestionService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

  @Autowired
  QuestionService questionService;

  @GetMapping("allQuestions")
  public List<Question> getAllQuestions() {
    return questionService.getAllQuestions();
  }

  @GetMapping("category/{category}")
  public List<Question> getQuestionsByCategory(@PathVariable String category) {
    return questionService.getQuestionsByCategory(category);
  }

  //request to add questions
  @PostMapping
  public Question addQuestion(@RequestBody Question question) {
    return questionService.addQuestion(question);
  }
}
