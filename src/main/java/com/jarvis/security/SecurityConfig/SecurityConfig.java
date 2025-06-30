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
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(
                                "/api/student/**","/api/department/**"
                        )
                        .permitAll()
                        //.authenticated()
                        .anyRequest().denyAll()   // 403 Forbidden for every other path
                )
                .httpBasic();                 // or formLogin(), jwt(), etc.
        return http.build();
    }
}
