package com.example.bbs4.domain.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "product")
public class Product {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long Number;

    @Column(nullable = false) // Not null 찍힘
    private  String name;

    @Column(nullable = false)
    private  Integer price;

    @Column(nullable = false)
    private  Integer stock;

    private LocalDateTime createdAT;
    private LocalDateTime updatedAT;


}
