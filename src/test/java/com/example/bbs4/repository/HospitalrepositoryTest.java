package com.example.bbs4.repository;

import com.example.bbs4.domain.entity.Hospital;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class HospitalrepositoryTest {

    @Autowired
    Hospitalrepository hospitalrepository;

    @Test
    @DisplayName("BusinessTypeName이 보건소 보건지소 보건진료소인 데이터가 잘 나오는지")
    void findByBusinessTypeNameIn() {
        List<String> inClues = new ArrayList<>();
        inClues.add("보건소");
        inClues.add("보건지소");
        inClues.add("보건진료소");
        List<Hospital> hospitals = hospitalrepository.findByBusinessTypeNameIn(inClues);
        for (var hospital :
                hospitals) {
            System.out.println(hospital.getHospitalName());
        }
    }

    @Test
    @DisplayName("병상 수 조회")
    void findBypatientRoomCountBetween(){
        List<Hospital> hospitals = hospitalrepository.findBypatientRoomCountBetween(5 ,19);
        for (var hospital : hospitals) {
            System.out.printf("%s %d\n",hospital.getHospitalName(), hospital.getPatientRoomCount());
        }
    }


    @Test
    void findByPatientRoomCountBetweenOrderByPatientRoomCountDesc(){
        List<Hospital>hospitals = hospitalrepository.findByPatientRoomCountBetweenOrderByPatientRoomCountDesc(5, 19);
        for (var hospital: hospitals) {
            System.out.println(hospital.getBusinessTypeName());
        }
    }
}






