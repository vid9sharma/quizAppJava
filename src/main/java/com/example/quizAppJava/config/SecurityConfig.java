package com.example.quizAppJava.config;

import com.example.quizAppJava.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.NoOp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.authentication.dao.*;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Autowired
  private MyUserDetailsService myUserDetailsService;

  @Autowired
  private JwtFilter jwtFilter;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    return httpSecurity.authorizeHttpRequests(requests -> requests.anyRequest().authenticated())
        .oauth2Login(Customizer.withDefaults())
        .build();
//    return httpSecurity
//        // enable cors
////        .cors(Customizer.withDefaults())
//        // disable crsf and create stateless http
//        .csrf(customizer -> customizer.disable())
//
//        // all requests need to be authenticated
//        .authorizeHttpRequests(request -> request
//            .requestMatchers("user/register", "user/updatePassword", "user/generateJwtToken")
//            .permitAll()
//            .anyRequest().authenticated())
//        // enable form login
////        .formLogin(Customizer.withDefaults())
//        // enable login for REST APIs
//        .httpBasic(Customizer.withDefaults())
//        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//        .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
//        .build();

  }

//  @Bean
//  public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
//    return config.getAuthenticationManager();
//  }
//
//  @Bean
//  public AuthenticationProvider authenticationProvider() {
//    //Database authentication
//    DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//    provider.setPasswordEncoder(new BCryptPasswordEncoder(10));
//    provider.setUserDetailsService(myUserDetailsService);
//
//    return provider;
//  }
}
