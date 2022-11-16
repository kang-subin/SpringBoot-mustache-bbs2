package com.example.bbs4.domain.entity;

import com.example.bbs4.domain.dto.ArticleDto;
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
@Table(name = "article3")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //  db에서 id 값을 다루도록 선언
    private Long id;
    private String title;
    private String content;

    public static ArticleDto of(Article article) { // article 에서 dto로 보내기
        return new ArticleDto(article.getId(), article.getTitle(), article.getContent());
    }
}





