package com.jarvis.security.repository;

import com.jarvis.security.entity.UserLoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserLoginRepo extends MongoRepository<UserLoginEntity, String> {

    UserLoginEntity getByMobilenumber(String mobilenumber);

}