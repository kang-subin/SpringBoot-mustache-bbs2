package com.example.bbs4.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor

public class VisitRequest {

    private Integer hospitalId;
    private String disease;
    private float amount;

}
