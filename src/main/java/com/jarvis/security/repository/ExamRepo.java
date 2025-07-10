package com.jarvis.security.repository;

import com.jarvis.security.entity.ExamInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExamRepo extends MongoRepository<ExamInfo,String> {
}
