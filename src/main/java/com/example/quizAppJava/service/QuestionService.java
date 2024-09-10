package com.example.quizAppJava.service;

import com.example.quizAppJava.DAO.QuestionDAO;
import com.example.quizAppJava.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

  @Autowired
  QuestionDAO questionDAO;

  public List<Question> getAllQuestions() {
    return questionDAO.findAll();
  }

  public List<Question> getQuestionsByCategory(String category) {
    return questionDAO.findByCategory(category);
  }

  public Question addQuestion(Question question) {
    return questionDAO.save(question);
  }
}
