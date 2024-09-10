package com.example.quizAppJava.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class MyUserDetails implements UserDetails {

  private MyUser myUser;

  public MyUserDetails(MyUser myUser) {
    this.myUser = myUser;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return Collections.singleton(new SimpleGrantedAuthority("USER"));
  }

  @Override
  public String getPassword() {
    return myUser.getPassword();
  }

  @Override
  public String getUsername() {
    return myUser.getUsername();
  }
}
