package com.example.bbs4.controller;

import com.example.bbs4.domain.entity.HospitalResponse;
import com.example.bbs4.domain.entity.Hospital;
import com.example.bbs4.repository.Hospitalrepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController // ui 형태가 아닌 json 형식으로 데이터를 제공하려고
@RequestMapping("/api/v1/hospitals") // 데이터를 주는것?

public class HospitalRestController {

    private final Hospitalrepository hospitalrepository;

    public HospitalRestController(Hospitalrepository hospitalrepository) {
        this.hospitalrepository = hospitalrepository;
    }


    @GetMapping("/{id}") // entity, dto 분리
    public ResponseEntity<HospitalResponse> get(@PathVariable Integer id) { // id 입력하면
        Optional<Hospital> hospital = hospitalrepository.findById(id); // Entity를 통해 데이터 받고,
        HospitalResponse hospitalResponse = Hospital.of(hospital.get()); // 받은 데이터를 HospitalResponse(dto역할)로 전달
        return ResponseEntity.ok().body(hospitalResponse); // ResponeseEntity를 통해 dto의 데이터 받고 응답결과 알려줌 (RestController라서 이 형식으로 데이터를 보여줌)
    }
}



