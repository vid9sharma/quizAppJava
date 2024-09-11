package com.example.quizAppJava.controller;

import com.example.quizAppJava.model.MyUser;
import com.example.quizAppJava.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class MyUserController {

  @Autowired
  private MyUserService myUserService;

  @PostMapping("register")
  public MyUser register(@RequestBody MyUser myUser) {
    return myUserService.register(myUser);
  }

  @PutMapping("updatePassword")
  public MyUser updatePassword(@RequestBody MyUser myUser) throws Exception {
    return myUserService.updatePassword(myUser);
  }
}
