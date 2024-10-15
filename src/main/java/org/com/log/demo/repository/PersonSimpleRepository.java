package org.com.log.demo.repository;

import org.com.log.demo.model.PersonSimple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonSimpleRepository extends JpaRepository<PersonSimple, Long> {
}
