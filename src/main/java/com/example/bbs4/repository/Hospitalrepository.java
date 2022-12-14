package com.example.bbs4.repository;

import com.example.bbs4.domain.entity.Hospital;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Hospitalrepository extends JpaRepository <Hospital, Integer> {
    List<Hospital> findByBusinessTypeNameIn(List<String> businessTypes);

    List<Hospital> findBypatientRoomCountBetween(int patientRoomCount, int patientRoomCount2);

    List<Hospital> findByPatientRoomCountBetweenOrderByPatientRoomCountDesc(int a, int b); // Between으로 병상수 10 ~20 미만을 조회하고, orderBy로 내림차순 정렬

    Page<Hospital> findByRoadNameAddressContaining(String keyword, Pageable pageable); // 도로명 주소로 찾을 수 있도록 하는 메소드

}

