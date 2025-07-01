package com.jarvis.security.service;


import com.jarvis.security.dto.UserInfo;
import com.jarvis.security.entity.User;

import java.util.List;
import java.util.Map;


public interface CommonServices {

    User createUserAccount(UserInfo userDataInfo);

    String updatePassword(String mobilenumber, String password);

    String checkuserIsValidOrNot(String mobilenumber, String password);





}