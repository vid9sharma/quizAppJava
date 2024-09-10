package com.example.quizAppJava.service;

import com.example.quizAppJava.DAO.MyUserDAO;
import com.example.quizAppJava.model.MyUserDetails;
import com.example.quizAppJava.model.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

  @Autowired
  private MyUserDAO myUserDAO;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    MyUser user = myUserDAO.findByUsername(username);

    if (user == null) throw new UsernameNotFoundException("User not found");

    return new MyUserDetails(user);
  }
}
