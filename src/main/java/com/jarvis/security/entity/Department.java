package com.jarvis.security.entity;

import org.springframework.data.mongodb.core.mapping.Field;

public class Department {

    @Field(name="depatment_name")
    private String departmentName;

    private String location;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String lacation) {
        this.location = lacation;
    }


}