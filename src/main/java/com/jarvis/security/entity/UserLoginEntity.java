package com.jarvis.security.entity;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="loginCredientials")
public class UserLoginEntity {

    @Id
    private String mobilenumber;
    private String password;

    public String getMobilenumber() {
        return mobilenumber;
    }
    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


}