package com.example.quizAppJava.service;

import com.example.quizAppJava.DAO.QuestionDAO;
import com.example.quizAppJava.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

  @Autowired
  private QuestionDAO questionDAO;

  public ResponseEntity<List<Question>> getAllQuestions() {
    try {
      return new ResponseEntity<>(questionDAO.findAll(), HttpStatus.OK);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
  }

  public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
    try {
      return new ResponseEntity<>(questionDAO.findByCategory(category), HttpStatus.OK);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

  }

  public ResponseEntity<List<Question>> getQuestionsByDifficultyLevel(String level) {
    try {
      return new ResponseEntity<>(questionDAO.findByDifficultyLevel(level), HttpStatus.OK);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
  }

  public ResponseEntity<Question> addQuestion(Question question) {
    try {
      return new ResponseEntity<>(questionDAO.save(question), HttpStatus.CREATED);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
  }
}
