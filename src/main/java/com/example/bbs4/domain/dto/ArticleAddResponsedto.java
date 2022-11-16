package com.example.bbs4.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
@AllArgsConstructor
@Getter
public class ArticleAddResponsedto {
    private Long id;
    private String title;
    private String content;
}
