package com.jarvis.security.controller;

import com.jarvis.security.dto.UserInfo;
import com.jarvis.security.entity.User;
import com.jarvis.security.service.CommonServices;
import com.jarvis.security.util.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private CommonServices commonServices;

    @CrossOrigin
    @PostMapping("/createAccount")
    public ResponseEntity<Object> createUserAccount(@RequestBody(required = true) UserInfo userData) {

        try {
            System.out.println("create user account");
            User resultData = commonServices.createUserAccount(userData);

            System.out.println(resultData);
            return ResponseHandler.generateResponse(HttpStatus.OK, true, "Success", resultData);
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException(e.getMessage());
        }

    }

    @CrossOrigin
    @GetMapping("/updatePassword")
    public ResponseEntity<Object> createUserAccount(
            @RequestHeader(value = "mobilenumber", required = true) String mobilenumber,
            @RequestHeader(value = "password", required = true) String password
    )  {

        try {

            String resultData = commonServices.updatePassword(mobilenumber,password);

            System.out.println(resultData);
            return ResponseHandler.generateResponse(HttpStatus.OK, true, "Success", resultData);
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException(e.getMessage());
        }

    }

    @CrossOrigin
    @GetMapping("/checkuserIsValidOrNot")
    public ResponseEntity<Object> checkuserIsValidOrNot(
            @RequestHeader(value = "mobilenumber", required = true) String mobilenumber,
            @RequestHeader(value = "password", required = true) String password
    )  {

        try {

            String resultData = commonServices.checkuserIsValidOrNot(mobilenumber,password);

            if(resultData.equals("login Sucesfully")) {
                return ResponseHandler.generateResponse(HttpStatus.OK, true, "Success", resultData);
            }else {
                return ResponseHandler.generateResponse(HttpStatus.UNAUTHORIZED, true, "Success", resultData);
            }

        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException(e.getMessage());
        }

    }



}