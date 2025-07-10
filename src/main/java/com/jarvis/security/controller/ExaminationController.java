package com.jarvis.security.controller;

import com.jarvis.security.entity.ExamInfo;
import com.jarvis.security.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/exam")
public class ExaminationController {

    @Autowired
    ExamService examService;

    @PostMapping("/addExam")
    public ExamInfo examSchedulInfor(@RequestBody ExamInfo exam){

        return examService.schedulExam(exam);
    }

    @GetMapping("/getExamSchedul")
    public List<ExamInfo> getExamSchedul(){

        return examService.getExamSchedulData();
    }
}
