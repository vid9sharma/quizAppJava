package com.example.quizAppJava.service;

import com.example.quizAppJava.DAO.MyUserDAO;
import com.example.quizAppJava.model.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyUserService {

  @Autowired
  private MyUserDAO myUserDAO;

  private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10);

  public MyUser register(MyUser myUser) {
    myUser.setPassword(bCryptPasswordEncoder.encode(myUser.getPassword()));
    return myUserDAO.save(myUser);
  }

  public MyUser updatePassword(MyUser myUser) throws Exception {
    MyUser existingUser = myUserDAO.findByUsername(myUser.getUsername());

    if (existingUser == null) {
      throw new Exception("User not found!");
    }

    existingUser.setPassword(bCryptPasswordEncoder.encode(myUser.getPassword()));
    return myUserDAO.save(existingUser);
  }
}
