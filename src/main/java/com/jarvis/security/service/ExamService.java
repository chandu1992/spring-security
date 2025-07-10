package com.jarvis.security.service;

import com.jarvis.security.entity.ExamInfo;

import java.util.List;

public interface ExamService {
    ExamInfo schedulExam(ExamInfo exam);

    List<ExamInfo> getExamSchedulData();
}
