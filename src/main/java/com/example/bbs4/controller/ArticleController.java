package com.example.bbs4.controller;


import com.example.bbs4.domain.dto.ArticleDto;
import com.example.bbs4.domain.entity.Article;
import com.example.bbs4.repository.Articlerepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/article")
public class ArticleController {

    private final Articlerepository articlerepository;

    public ArticleController(Articlerepository articlerepository) {
        this.articlerepository = articlerepository;
    }


    @GetMapping(value = "/new")
    public String ArticlecreatePage() {
        return "new";
    }

    @GetMapping(value = "/{id}") // 내용이 저장 된 후 id 내용이 보여짐
    public String showSingle(@PathVariable Long id, Model model) {
        Optional<Article> optionalArticle = articlerepository.findById(id);
        if (!optionalArticle.isEmpty()) {
            model.addAttribute("articles", optionalArticle.get());
            return "show";
        } else {
            return "error";
        }
    }

    @GetMapping("") // list 기본화면
    public String showList(Model model) { // 특정 id 값을 넘겨서 찾는것이 아니니까 model 만 이용
        List<Article> ArticleList = articlerepository.findAll(); // entity 객체 리스트
        model.addAttribute("articles", ArticleList);
        return "list";

    }

    @PostMapping("")
    public String createArticle(ArticleDto articledto) { // new sumit 버튼 눌러 저장
        Article savedArticle = articlerepository.save(articledto.toEntity()); //view 를 통해 dto 에 들어온 값을 article에 저장
        return String.format("redirect:/article/%d", savedArticle.getId()); // id 조회해서 show로 이동 (model은 controller에 있는 값을 view로 전달함 , 이 경우 entity에서 id 값만 가져와서 view에 보여주는 방식이 아니라 주소에 삽입하는 형식이라서 model 사용 안한듯?
    }


    @GetMapping("/{id}/edit")
    public String editArticle(@PathVariable Long id, Model model) {
        Optional<Article> optionalArticle = articlerepository.findById(id);
        if (!optionalArticle.isEmpty()) {
            model.addAttribute("articles", optionalArticle.get());
            return "edit";
        } else {
            return "error";
        }
    }




}