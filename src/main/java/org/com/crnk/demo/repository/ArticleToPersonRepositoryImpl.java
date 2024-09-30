package org.com.crnk.demo.repository;


import io.crnk.core.repository.RelationshipRepositoryBase;
import org.com.crnk.demo.model.Article;
import org.com.crnk.demo.model.Person;
import org.springframework.stereotype.Component;

@Component
public class ArticleToPersonRepositoryImpl
        extends RelationshipRepositoryBase<Article, Long, Person, Long> {

    public ArticleToPersonRepositoryImpl() {
        super(Article.class, Person.class);
    }
}
