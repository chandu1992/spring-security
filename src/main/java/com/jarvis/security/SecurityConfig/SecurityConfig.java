package com.jarvis.security.SecurityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
              //  .csrf(csrf -> csrf.disable()) // if we comment this line the req which have capability to change data like POST, DELETE, PUT required CSRF token to access that api
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(
                                "/api/student/**","/api/department/**","/user/**","/csrf"
                        )
                        .permitAll()
                        //.authenticated()
                        .anyRequest().denyAll()   // 403 Forbidden for every other path
                )
                .httpBasic();                 // or formLogin(), jwt(), etc.
        return http.build();
    }
}
