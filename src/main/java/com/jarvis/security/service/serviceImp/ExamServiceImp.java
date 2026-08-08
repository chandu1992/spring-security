package com.jarvis.security.service.serviceImp;

import com.jarvis.security.entity.ExamInfo;
import com.jarvis.security.repository.ExamRepo;
import com.jarvis.security.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamServiceImp implements ExamService {

    @Autowired
    ExamRepo examRepo;
    @Override
    public ExamInfo schedulExam(ExamInfo exam) {
        System.out.println("chandra");
        return examRepo.save(exam);
    }

    @Override
    public List<ExamInfo> getExamSchedulData() {
        return examRepo.findAll();
    }
}
