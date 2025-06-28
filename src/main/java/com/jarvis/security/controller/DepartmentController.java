package com.jarvis.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/department")
public class DepartmentController {

    @GetMapping("/getDpName")
    public String getDepartemntName(){
        return "IT Department";
    }
}
