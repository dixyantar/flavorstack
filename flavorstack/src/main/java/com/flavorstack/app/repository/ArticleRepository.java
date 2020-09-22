package com.flavorstack.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.flavorstack.app.data.Article;

public interface ArticleRepository extends CrudRepository<Article, Long> {

}
