package wuhao.springboot.database.service;

import wuhao.springboot.database.entity.Article;

import java.util.List;

/**
 * @author PC
 */


public interface ArticleService {
    Article saveArticle(Article article);

    void deleteArticle(Long id);

    void updateArticle(Article article);

    Article getArticle(Long id);

    List<Article> getAll();

}
