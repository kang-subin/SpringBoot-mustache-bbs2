package com.example.bbs4.repository;

import com.example.bbs4.domain.entity.Hospital;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class HospitalrepositoryTest {

    @Autowired Hospitalrepository hospitalrepository;

    @Test
    void findById(){
        Optional<Hospital> hospital = hospitalrepository.findById(1);
        Hospital hp = hospital.get();
        System.out.println(hp.getId());
        assertEquals(1, hp.getId());
    }

}