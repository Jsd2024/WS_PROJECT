package org.com.crnk.demo.repository;

import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.resource.list.ResourceList;
import org.com.crnk.demo.model.Article;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ArticleRepositoryImpl extends ResourceRepositoryBase<Article, Long>
    implements ArticleRepository {

  private Map<Long, Article> articles = new ConcurrentHashMap<>();

  public ArticleRepositoryImpl() {
    super(Article.class);
  }

  @Override
  public synchronized void delete(Long id) {
    articles.remove(id);
  }

  @Override
  public synchronized <S extends Article> S save(S article) {
    articles.put(article.getId(), article);
    return article;
  }

  @Override
  public synchronized ResourceList<Article> findAll(QuerySpec querySpec) {
    return querySpec.apply(articles.values());
  }
}
