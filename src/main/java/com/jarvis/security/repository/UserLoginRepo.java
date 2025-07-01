package com.jarvis.security.repository;

import com.jarvis.security.entity.UserLoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoginRepo extends JpaRepository<UserLoginEntity, String> {

    UserLoginEntity getByMobilenumber(String mobilenumber);

}