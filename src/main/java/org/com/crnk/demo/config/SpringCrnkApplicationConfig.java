package org.com.crnk.demo.config;

import javax.annotation.PostConstruct;

import org.com.crnk.demo.model.Article;
import org.com.crnk.demo.model.Person;
import org.com.crnk.demo.model.Task;
import org.com.crnk.demo.repository.ArticleRepository;
import org.com.crnk.demo.repository.PersonRepository;
import org.com.crnk.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SpringCrnkApplicationConfig {

  @Autowired
  ArticleRepository articleRepository;

  @Autowired
  PersonRepository personRepository;

  @PostConstruct
  public void init() {
    Article article1 = new Article(1L, "JSON API paints my bikeshed!");
    Article article2 = new Article(2L, "Rails is Omakase");

    Person person1 = new Person(1L, "John");

    article1.setAuthor(person1);
    article2.setAuthor(person1);

    person1.getArticles().add(article1);
    person1.getArticles().add(article2);

    articleRepository.save(article1);
    articleRepository.save(article2);

    personRepository.save(person1);
  }

//  @Autowired
//  TaskService taskService;
//
//  @PostConstruct
//  public void init() {
//    Task task = new Task//();
//            (1234567890123456789L, "task001", "Task001Desc");
////        task.setDescription("Task001Desc");
////        task.setName("task001");
//    taskService.saveTask(task);
//  }
}
