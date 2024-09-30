package org.com.crnk.demo.model;

import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;

import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@JsonApiResource(type = "people")
public class Person {

  @JsonApiId
  private Long id;

  private String name;

  // One Project can have many Tasks
  // One Person/author can have many Articles
  @OneToMany(mappedBy = "author")
  @JsonApiRelation(opposite = "author")
  private List<Article> articles = new ArrayList<>();

  public Person() {
    super();
  }

  public Person(Long id, String name) {
    super();
    this.id = id;
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Article> getArticles() {
    return articles;
  }

  public void setArticles(List<Article> articles) {
    this.articles = articles;
  }

  @Override
  public String toString() {
    return "person[id=" + id + ", name=" + name + "]";
  }
}
