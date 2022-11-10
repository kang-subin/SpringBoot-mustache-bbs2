package com.example.bbs4.repository;

import com.example.bbs4.domain.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Articlerepository extends JpaRepository <Article, Long> {
}
