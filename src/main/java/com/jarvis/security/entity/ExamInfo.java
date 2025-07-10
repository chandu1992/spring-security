package com.jarvis.security.entity;

import jakarta.persistence.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection="ExamInfo")
public class ExamInfo {

    @Id
    private String id;

    private String subject;

    private String examType; // e.g., Midterm, Final, Quiz

    private LocalDate examDate;

    private String location;

    private int durationInMinutes;

    private String instructor;

    // === Constructors ===

    public ExamInfo() {
    }

    public ExamInfo(String subject, String examType, LocalDate examDate, String location, int durationInMinutes, String instructor) {
        this.subject = subject;
        this.examType = examType;
        this.examDate = examDate;
        this.location = location;
        this.durationInMinutes = durationInMinutes;
        this.instructor = instructor;
    }

    // === Getters and Setters ===

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getExamType() {
        return examType;
    }

    public void setExamType(String examType) {
        this.examType = examType;
    }

    public LocalDate getExamDate() {
        return examDate;
    }

    public void setExamDate(LocalDate examDate) {
        this.examDate = examDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }
}
