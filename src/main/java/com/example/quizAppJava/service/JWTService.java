package com.example.quizAppJava.service;

import org.springframework.stereotype.Service;

@Service
public class JWTService {

  public String generateToken() {
    return "This is your JWT Token";
  }
}
