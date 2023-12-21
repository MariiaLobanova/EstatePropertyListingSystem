package com.example.SpringDataJPA.config;

import com.example.SpringDataJPA.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

   private final UserService userDetailsService;

   public SecurityConfig(UserService userDetailsService) {
      this.userDetailsService = userDetailsService;
   }

   @Bean
   public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
      return configuration.getAuthenticationManager();
   }

   @Bean
   public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
      // authenticate
      AuthenticationManagerBuilder authenticationManagerBuilder = httpSecurity
              .getSharedObject(AuthenticationManagerBuilder.class);
      authenticationManagerBuilder
              .userDetailsService(userDetailsService)
              .passwordEncoder(passwordEncoder());
      AuthenticationManager authenticationManager = authenticationManagerBuilder.build();

      httpSecurity.csrf(AbstractHttpConfigurer::disable)
              .authorizeHttpRequests(auth -> auth
                      .requestMatchers("/api/users")
                      .permitAll()
                      .anyRequest()
                      .authenticated())
              .authenticationManager(authenticationManager)
              .httpBasic(Customizer.withDefaults());

      return httpSecurity.build();
   }

   @Bean
   public PasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
   }
}
