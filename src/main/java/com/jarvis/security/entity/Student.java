package com.jarvis.security.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

//represent collection student
@Document(collection="student")
public class Student {

    @Id
    private String id;

    @Field(name="name")
    private String name;

    @Field(name="mail")
    private String email;

    @Field(name="deparment")
    private Department deparment;

    @Field(name="subjects")
    private List<Subject> subjects;

    @Transient
    private double percentage;

//	public Student(String id, Department deparment) {
//		super();
//		this.id = id;
//		this.deparment = deparment;
//	}

    //if more than one contructor need to add this annotation
//	@PersistenceConstructor
//	public Student(String id, String name, String email, Department deparment, List<Subject> subjects) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.email = email;
//		this.deparment = deparment;
//		this.subjects = subjects;
//	}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDeparment() {
        return deparment;
    }

    public void setDeparment(Department deparment) {
        this.deparment = deparment;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public double getPercentage() {
        if(subjects!=null && subjects.size()>0) {
            int total=0;
            for(Subject subject:subjects) {
                total += subject.getMarkObtained();
            }
            return total/subjects.size();
        }
        return 0.00;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }


}
