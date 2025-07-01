package com.jarvis.security.service.serviceImp;

import com.jarvis.security.dto.UserInfo;
import com.jarvis.security.entity.User;
import com.jarvis.security.entity.UserLoginEntity;
import com.jarvis.security.repository.UserLoginRepo;
import com.jarvis.security.repository.UserRepository;
import com.jarvis.security.service.CommonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonServiceImpl implements CommonServices {

    @Autowired
    private UserRepository userInfoRepo;

    @Autowired
    private UserLoginRepo userLoginRepo;

    @Override
    public User createUserAccount(UserInfo userDataInfo) {
        // TODO Auto-generated method stub


        User userEntity= new User();

        userEntity.setFirstName(userDataInfo.getFirstName());
        userEntity.setLastname(userDataInfo.getLastname());
        userEntity.setMobileNumber(userDataInfo.getMobileNumber());
        userEntity.setBirthDate(userDataInfo.getBirthDate());
        userEntity.setGender(userDataInfo.getGender());

        userInfoRepo.save(userEntity);

        UserLoginEntity userLoginEntity = new UserLoginEntity();
        userLoginEntity.setMobilenumber(userDataInfo.getMobileNumber());
        userLoginEntity.setPassword(userDataInfo.getPassword());

        userLoginRepo.save(userLoginEntity);




        return userEntity;
    }

    @Override
    public String updatePassword(String mobilenumber, String password) {
        // TODO Auto-generated method stub
        try {

            UserLoginEntity userPresent = userLoginRepo.getByMobilenumber(mobilenumber);

            if(userPresent!=null) {
                UserLoginEntity userLoginEntity = new UserLoginEntity();
                userLoginEntity.setMobilenumber(mobilenumber);
                userLoginEntity.setPassword(password);
                userLoginRepo.save(userLoginEntity);
                return "password updated successfully";
            }else {
                return "Please enter correct mobile number or email id";
            }

        }catch(Exception e) {
            return "Somethning went wrong";
        }

    }

    @Override
    public String checkuserIsValidOrNot(String mobilenumber, String password) {

        try {

            UserLoginEntity userPresent = userLoginRepo.getByMobilenumber(mobilenumber);

            if(userPresent!=null) {
                return "login Sucesfully";
            }else {
                return "unauthorized user";
            }

        }catch(Exception e) {
            return "Somethning went wrong";
        }
    }



}
