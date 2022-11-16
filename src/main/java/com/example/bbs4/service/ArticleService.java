package com.example.bbs4.service;

import com.example.bbs4.domain.dto.ArticleDto;
import com.example.bbs4.domain.entity.Article;
import com.example.bbs4.domain.entity.Hospital;
import com.example.bbs4.domain.entity.HospitalResponse;
import com.example.bbs4.repository.Articlerepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ArticleService {

    private final Articlerepository articlerepository;


    public ArticleService(Articlerepository articlerepository) {
        this.articlerepository = articlerepository;
    }

    public ArticleDto getArticleById(Long id) { // 리포에서 받은 값 DTO로 넘겨주는 메소드
        Optional<Article> optArticle = articlerepository.findById(id); // 리포에서 가져온 값이 article에 들어감
        ArticleDto articleDto = Article.of(optArticle.get()); //article of(메소드)는 articleDto로 전달
        return articleDto;
    }
}



