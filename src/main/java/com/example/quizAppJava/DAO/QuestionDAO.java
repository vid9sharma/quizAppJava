package com.example.quizAppJava.DAO;

import com.example.quizAppJava.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDAO extends JpaRepository<Question, Integer> {

  List<Question> findByCategory(String category);

  List<Question> findByDifficultyLevel(String level);
}
