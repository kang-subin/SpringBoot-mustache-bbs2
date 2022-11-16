package com.example.bbs4.service;

import com.example.bbs4.domain.dto.ArticleAddRequestdto;
import com.example.bbs4.domain.dto.ArticleAddResponsedto;
import com.example.bbs4.domain.dto.ArticleDto;
import com.example.bbs4.domain.entity.Article;
import com.example.bbs4.repository.Articlerepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ArticleService {

    private Long id;
    private String title;
    private String content;

    private final Articlerepository articlerepository;
    public ArticleService(Articlerepository articlerepository) {
        this.articlerepository = articlerepository;
    }


    public ArticleDto getArticleById(Long id) { // 리포에서 받은 값 DTO로 넘겨주는 메소드
        Optional<Article> optArticle = articlerepository.findById(id); // 리포에서 가져온 값이 article에 들어감
        ArticleDto articleDto = Article.of(optArticle.get()); //article of(메소드)는 articleDto로 전달
        return articleDto;
    }


    public ArticleAddResponsedto add(ArticleAddRequestdto dto) {
        Article article = dto.toEntity();
        Article savedArticle = articlerepository.save(article);
        return new ArticleAddResponsedto(savedArticle.getId(), savedArticle.getTitle(), savedArticle.getContent());
    }

}



