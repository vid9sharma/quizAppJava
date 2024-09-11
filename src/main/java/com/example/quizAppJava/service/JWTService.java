package com.example.quizAppJava.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.beans.Encoder;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JWTService {

  public String generateToken(String username) throws NoSuchAlgorithmException {

    Map<String, Object> claims = new HashMap<>();
    return Jwts.builder()
        .claims()
        .add(claims)
        .subject(username)
        .issuedAt(new Date(System.currentTimeMillis()))
        .expiration(new Date(System.currentTimeMillis() + 60*60*30))
        .and()
        .signWith(getKey())
        .compact();
  }

  public Key getKey() throws NoSuchAlgorithmException {
    KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256");
    SecretKey secretKey = keyGenerator.generateKey();

    return Keys.hmacShaKeyFor(secretKey.getEncoded());
  }
}
