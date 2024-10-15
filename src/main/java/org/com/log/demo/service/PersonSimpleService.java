package org.com.log.demo.service;

import org.com.log.demo.model.PersonSimple;
import org.com.log.demo.repository.PersonSimpleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonSimpleService {

    @Autowired
    private PersonSimpleRepository personSimpleRepository;

    public List<PersonSimple> getAllPersons() {
        return personSimpleRepository.findAll();
    }

    public PersonSimple savePerson(PersonSimple personSimple) {
        return personSimpleRepository.save(personSimple);
    }
}
