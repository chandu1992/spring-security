package com.jarvis.security.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/csrf")
public class CsrfTokenController {

    @GetMapping("/token")
    public CsrfToken getCsrfToken(HttpServletRequest req){
        return (CsrfToken) req.getAttribute("_csrf");
    }
}
