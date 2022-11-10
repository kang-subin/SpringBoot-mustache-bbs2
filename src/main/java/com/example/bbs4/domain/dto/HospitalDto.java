package com.example.bbs4.domain.dto;

import com.example.bbs4.domain.entity.Article;
import com.example.bbs4.domain.entity.Hospital;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
@AllArgsConstructor
public class HospitalDto {
    private Integer id;
    private String openServiceName;
    private int openLocalGovernmentCode;
    private String managementNumber;
    private LocalDateTime licenseDate;
    private int businessStatus;
    private int businessStatusCode;
    private String phone;
    private String fullAddress;
    private String roadNameAddress;
    private String hospitalName;
    private String businessTypeName;
    private int healthcareProviderCount;
    private int patientRoomCount;
    private int totalNumberOfBeds;
    private float totalAreaSize;

public Hospital toEntity (){
    return new Hospital (id, openServiceName,openLocalGovernmentCode ,
            managementNumber,licenseDate
            ,businessStatus, businessStatusCode , phone
    ,fullAddress, roadNameAddress, hospitalName
    ,businessTypeName, healthcareProviderCount, patientRoomCount
    ,totalNumberOfBeds, totalAreaSize);
}

}
