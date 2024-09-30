package org.com.crnk.demo.controller;

import org.com.crnk.demo.model.PersonSimple;
import org.com.crnk.demo.service.PersonSimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonSimpleService personSimpleService;

    @GetMapping
    public List<PersonSimple> getAllPersons() {
        return personSimpleService.getAllPersons();
    }

    @PostMapping
    public PersonSimple savePerson(@RequestBody PersonSimple personSimple) {

        return personSimpleService.savePerson(personSimple);
    }
}
