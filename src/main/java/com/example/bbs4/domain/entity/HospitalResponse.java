package com.example.bbs4.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
    @Builder
    @Getter
    public class HospitalResponse { //dto 생략
        private Integer id;
        private String roadNameAddress;
        private String hospitalName;
        private Integer patientRoomCount;
        private Integer totalNumberOfBeds;
        private String businessTypeName;
        private Float totalAreaSize;
    }

