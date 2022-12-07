package com.example.bbs4.controller;

import com.example.bbs4.domain.dto.VisitRequest;
import com.example.bbs4.domain.dto.VisitResponse;
import com.example.bbs4.service.VisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class VisitController {

    private final VisitService visitService;

    @PostMapping("/visits")
    public ResponseEntity<String> add (@RequestBody VisitRequest visitRequest, Authentication authentication){
        String userName = authentication.getName();
        visitService

        return ResponseEntity.ok().body(visitRequest.getDisease());

    }


}
