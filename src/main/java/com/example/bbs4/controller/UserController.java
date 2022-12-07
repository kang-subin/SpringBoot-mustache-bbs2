package com.example.bbs4.controller;

import com.example.bbs4.domain.dto.UserLoginRequest;
import com.example.bbs4.domain.dto.UserLoginResponse;
import com.example.bbs4.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login (@RequestBody UserLoginRequest userRequest){
        UserLoginResponse userLoginResponse = userService.login(userRequest.getUserName(),userRequest.getPassword());
        return ResponseEntity.ok().body(userLoginResponse.getToken());
    }
}


