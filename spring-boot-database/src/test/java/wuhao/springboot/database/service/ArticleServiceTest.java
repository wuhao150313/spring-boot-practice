package wuhao.springboot.database.service;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import wuhao.springboot.database.entity.Article;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class ArticleServiceTest {
    @Resource
    private ArticleService articleService;

    @Test
    void saveArticle() {
        Article article = Article.builder()
                .title("SpringBoot")
                .author("张三")
                .content("SpringBoot 从入门到精通")
                .build();
        Article saveArticle = articleService.saveArticle(article);
        log.info(String.valueOf(saveArticle));
    }

    @Test
    void deleteArticle() {


    }

    @Test
    void updateArticle() {
        Article article = articleService.getArticle(1L);
        article.setTitle("SpringBoot222");
        articleService.updateArticle(article);
    }

    @Test
    void getArticle() {
        Article article = articleService.getArticle(1L);
        log.info(String.valueOf(article));
    }

    @Test
    void getAll() {
    }
}