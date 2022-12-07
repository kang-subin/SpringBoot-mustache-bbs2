package com.example.bbs4.service;

import com.example.bbs4.domain.dto.UserLoginRequest;
import com.example.bbs4.domain.dto.UserLoginResponse;
import com.example.bbs4.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Value("hello")
    private String secretKey;

    private Long expireTimeMs = 10000 * 60 * 60L;

    public UserLoginResponse login(String userName, String password){
        String token = JwtTokenUtil.createToken(userName,secretKey,expireTimeMs);
        return UserLoginResponse.builder()
                .token(token)
                .build();
    }
}
