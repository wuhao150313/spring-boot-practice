package wuhao.springboot.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wuhao.springboot.database.entity.Article;

/**
 * @author PC
 */
public interface ArticleRepository extends JpaRepository<Article, Long> {



}
