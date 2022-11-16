package com.example.bbs4.service;

import com.example.bbs4.domain.entity.Hospital;
import com.example.bbs4.domain.entity.HospitalResponse;
import com.example.bbs4.repository.Hospitalrepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service // entity를 통해 받아온 값에서 가공해서 controller에 넘겨주기 위해서 생긴 계층
public class HospitalService {

    private final Hospitalrepository hospitalrepository;


    public HospitalService(Hospitalrepository hospitalrepository) {
        this.hospitalrepository = hospitalrepository;
    }

public HospitalResponse getHospital (Integer id) { // db값을 rp로 넘기는 메소드
    Optional<Hospital> optHospital = hospitalrepository.findById(id); // rp를 통해서 entity db 값을 가져옴
    Hospital hospital = optHospital.get();// ?
    HospitalResponse hospitalResponse = Hospital.of(hospital); // hospital로 받아온 값을 rp로 넘김, 넘기는 값 중에서 BusinessStatusCode 의 경우 아래 로 가공해서 넘김

    if (hospital.getBusinessStatusCode() == 13) { // hospital에서 받아온 값이 13일 경우
        hospitalResponse.setBusinessStatusName("영업중"); // rp에 영업중이라 넘김
    } else if (hospital.getBusinessStatusCode() == 3) {
        hospitalResponse.setBusinessStatusName("폐업");
    } else{ hospitalResponse.setBusinessStatusName(String.valueOf(hospital.getBusinessStatusCode()));
    }

    return hospitalResponse;
}
}


