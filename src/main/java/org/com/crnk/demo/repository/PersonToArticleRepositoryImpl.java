package org.com.crnk.demo.repository;


import io.crnk.core.repository.RelationshipRepositoryBase;
import org.com.crnk.demo.model.Article;
import org.com.crnk.demo.model.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonToArticleRepositoryImpl
    extends RelationshipRepositoryBase<Person, Long, Article, Long> {

  public PersonToArticleRepositoryImpl() {
    super(Person.class, Article.class);
  }
}
