package com.example.bbs4.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
public class Hospital {
    @Id
    private Integer id;

    private String roadNameAddress;

    private String hospitalName;




    private Integer patientRoomCount;
    private Integer totalNumberOfBeds;
    private String businessTypeName;
    private Integer businessStatusCode;
    private Float totalAreaSize;


    public static HospitalResponse of(Hospital hospital) { // HospitalResponse Dto로 만들어주는 부분  static 한 이유 가독성을 위해서
        return new HospitalResponse(hospital.getId(),
                hospital.getRoadNameAddress(), hospital.getHospitalName(),
                hospital.getPatientRoomCount(), hospital.getTotalNumberOfBeds(), hospital.getBusinessTypeName(),
                hospital.getTotalAreaSize(), hospital.businessTypeName);
    }



}





