package com.happiestlearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.happiestlearning.entity.UserProfile;
import com.happiestlearning.service.UserServiceImpl;

@RestController
@RequestMapping("/atmos/api/user")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("/details")
    public UserProfile getAll() {

        return userServiceImpl.getUserInfo();
    }

}