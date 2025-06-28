package com.jarvis.security.entity;

import org.springframework.data.mongodb.core.mapping.Field;

public class Subject {

    @Field(name="subject_name")
    private String subjectName;

    @Field(name="marks")
    private int markObtained;

    public String getSubjectName() {
        return subjectName;
    }
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
    public int getMarkObtained() {
        return markObtained;
    }
    public void setMarkObtained(int markObtained) {
        this.markObtained = markObtained;
    }

}