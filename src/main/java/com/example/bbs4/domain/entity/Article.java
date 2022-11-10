package com.example.bbs4.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Table(name = "article3")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //  db에서 id 값을 다루도록 선언
    private Long id;
    private String title;
    private String content;

    public Article (String title , String content){
        this.title = title;
        this.content = content;
    }





}




