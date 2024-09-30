package org.com.crnk.demo.repository;

import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.resource.list.ResourceList;
import org.com.crnk.demo.model.Person;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class PersonRepositoryImpl extends ResourceRepositoryBase<Person, Long>
    implements PersonRepository {

  private Map<Long, Person> people = new ConcurrentHashMap<>();

  public PersonRepositoryImpl() {
    super(Person.class);
  }

  @Override
  public synchronized void delete(Long id) {
    people.remove(id);
  }

  @Override
  public synchronized <S extends Person> S save(S person) {
    people.put(person.getId(), person);
    return person;
  }

  @Override
  public synchronized ResourceList<Person> findAll(QuerySpec querySpec) {
    return querySpec.apply(people.values());
  }
}
