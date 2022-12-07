package com.example.bbs4.service;


import com.example.bbs4.domain.entity.Hospital;
import com.example.bbs4.domain.entity.HospitalResponse;
import com.example.bbs4.repository.Hospitalrepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;


class HospitalServiceTest {

    private Hospitalrepository hospitalrepository = Mockito.mock(Hospitalrepository.class);

    private HospitalService hospitalService;


    @BeforeEach
 void setUp(){

        hospitalService = new HospitalService(hospitalrepository);
    }


    @Test
    @DisplayName("3, 13일때 폐업, 영업중으로 나오는지")
    void businessStatusName3() { // find 라서 builder로 주입한 후 찾는건가?

            Hospital hospital1 = Hospital.builder()
                .id(718457)
                .businessStatusCode(3)
                .build();

        Hospital hospital2 = Hospital.builder()
                .id(718457)
                .businessStatusCode(13)
                .build();



        Mockito.when(hospitalrepository.findById(any()))
                .thenReturn(Optional.of(hospital1));

        HospitalResponse hospitalResponse = hospitalService.getHospital(718457);
        assertEquals(718457, hospitalResponse.getId());
        assertEquals("폐업", hospitalResponse.getBusinessStatusName());



        Mockito.when(hospitalrepository.findById(any()))
                .thenReturn(Optional.of(hospital2));


        HospitalResponse hospitalResponse1 = hospitalService.getHospital(718457);
        assertEquals(718457, hospitalResponse1.getId());
        assertEquals("영업중", hospitalResponse1.getBusinessStatusName());

    }
}




