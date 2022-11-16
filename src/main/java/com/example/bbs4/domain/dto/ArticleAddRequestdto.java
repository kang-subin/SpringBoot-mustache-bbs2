package com.example.bbs4.domain.dto;

import com.example.bbs4.domain.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ArticleAddRequestdto {

    private String title;
    private String content;

    public Article toEntity() { // entity로 변환

        Article article = Article.builder() //빌더 사용해서 생성자 안만들고 바로 article로 값 넘기기
                .title(this.title)
                .content(this.content)
                .build();
        return article;


    }
}


