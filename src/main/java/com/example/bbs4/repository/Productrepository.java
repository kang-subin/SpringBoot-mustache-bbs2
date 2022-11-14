package com.example.bbs4.repository;

import com.example.bbs4.domain.entity.Hospital;
import com.example.bbs4.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Productrepository extends JpaRepository <Product, Long> {
    };
