package com.example.quizAppJava.DAO;

import com.example.quizAppJava.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserDAO extends JpaRepository<MyUser, Integer> {

  MyUser findByUsername(String username);
}
