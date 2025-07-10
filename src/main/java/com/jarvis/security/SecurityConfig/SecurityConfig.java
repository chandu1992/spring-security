package com.jarvis.security.SecurityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF for stateless APIs
                .cors(withDefaults()) // enables CORS (Cross-Origin Resource Sharing) in the security filter
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api/csrf/token","/api/student/**").authenticated()
                        .requestMatchers("/api/department/**", "/api/user/**").permitAll()
                        .anyRequest().denyAll()
                )
                .httpBasic(withDefaults());

        return http.build();
    }


//    @Bean
//    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
////              .csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers(
//                                "/api/student/**","/api/department/**","/api/user/**","api/csrf/token"
//                        )
//                        .permitAll()
//                        .anyRequest().denyAll()
//                )
//                .httpBasic();
//        return http.build();
//    }

}
