package com.example.bbs4.service;

import com.example.bbs4.domain.dto.ArticleAddRequestdto;
import com.example.bbs4.domain.dto.ArticleAddResponsedto;
import com.example.bbs4.domain.dto.ArticleDto;
import com.example.bbs4.domain.entity.Article;
import com.example.bbs4.repository.Articlerepository;
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
// 이 경우는 id를 controller로 받아온 후 id 값에 해당하는 db를 entity에 담고 담은 후 dto로 다시 반환

    public ArticleAddResponsedto add(ArticleAddRequestdto dto) { //요청으로 받은 값을 entity로 넘긴 후
        Article article = dto.toEntity();
        Article savedArticle = articlerepository.save(article); // 요청 받은 값이 들어간 entity를 db에 저장
        return new ArticleAddResponsedto(savedArticle.getId(), savedArticle.getTitle(), savedArticle.getContent());
    } // 저장된 db 값을 응답으로 보냄 ( id 의 경우 db에서 알아서 지정하기 때문에 요청할때 id 를 넘기지 않아도 알아서 넘어옴)

}



