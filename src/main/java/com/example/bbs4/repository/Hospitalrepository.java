package com.example.bbs4.repository;

import com.example.bbs4.domain.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Hospitalrepository extends JpaRepository <Hospital, Integer > {
}

