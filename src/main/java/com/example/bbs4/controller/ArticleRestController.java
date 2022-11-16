package com.example.bbs4.controller;

import com.example.bbs4.domain.dto.ArticleAddRequestdto;
import com.example.bbs4.domain.dto.ArticleAddResponsedto;
import com.example.bbs4.domain.dto.ArticleDto;
import com.example.bbs4.service.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/articles")
public class ArticleRestController {

    private final ArticleService articleService;

    public ArticleRestController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleDto> getArticle(@PathVariable Long id) {
        ArticleDto articleDto = articleService.getArticleById(id);
        return ResponseEntity.ok().body(articleDto);
    }


    @PostMapping("/post")
    public ResponseEntity <ArticleAddResponsedto> addArticle(@RequestBody ArticleAddRequestdto dto){
    ArticleAddResponsedto responsedto = articleService.add(dto);
    return ResponseEntity.ok().body(responsedto);
    }


}

