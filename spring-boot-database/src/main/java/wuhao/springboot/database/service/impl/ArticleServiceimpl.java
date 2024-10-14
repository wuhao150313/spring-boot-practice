package wuhao.springboot.database.service.impl;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import wuhao.springboot.database.entity.Article;
import wuhao.springboot.database.repository.ArticleRepository;
import wuhao.springboot.database.service.ArticleService;

import java.util.List;
import java.util.Optional;


@Service
public class ArticleServiceimpl implements ArticleService {
    @Resource
    private ArticleRepository articleRepository;


    @Override
    public Article saveArticle(Article article) {
        articleRepository.save(article);
        return article;
    }

    @Override
    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);

    }

    @Override
    public void updateArticle(Article article) {
        articleRepository.save(article);

    }

    @Override
    public Article getArticle(Long id) {
        Optional<Article> optional = articleRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public List<Article> getAll() {
        return articleRepository.findAll();
    }
}
