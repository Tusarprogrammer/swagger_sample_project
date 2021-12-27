package com.happiestlearning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happiestlearning.entity.UserProfile;
import com.happiestlearning.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserProfile getUserInfo() {
        return userRepository.findByLogin("tpati");
    }

}
