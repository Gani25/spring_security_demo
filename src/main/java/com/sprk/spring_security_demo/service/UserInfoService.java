package com.sprk.spring_security_demo.service;

import com.sprk.spring_security_demo.entity.UserInfo;
import com.sprk.spring_security_demo.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String saveUser(UserInfo userInfo) {

        String encodePassword = passwordEncoder.encode(userInfo.getPassword());

        // Default Role for every user who register themself through browser
        String role = "ROLE_USER";

        userInfo.setPassword(encodePassword);
        userInfo.setRoles(role);

        userInfoRepository.save(userInfo);

        return "User Saved Successfully";


    }
}
