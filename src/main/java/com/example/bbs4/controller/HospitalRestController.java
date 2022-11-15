package com.example.bbs4.controller;

import com.example.bbs4.domain.entity.HospitalResponse;
import com.example.bbs4.domain.entity.Hospital;
import com.example.bbs4.repository.Hospitalrepository;
import com.example.bbs4.service.HospitalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController // ui 형태(MVC)가 아닌 json 형식으로 데이터를 제공하려고
@RequestMapping("/api/v1/hospitals") // 데이터를 주는것?

public class HospitalRestController {

    private final HospitalService hospitalService;

    public HospitalRestController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<HospitalResponse> get(@PathVariable Integer id) { // ResponseEntity도 DTO타입
        HospitalResponse hospitalResponse = hospitalService.getHospital(id); // DTO
        return ResponseEntity.ok().body(hospitalResponse); // rp에서 받아온 값 json 형태로 리턴
    }
}




