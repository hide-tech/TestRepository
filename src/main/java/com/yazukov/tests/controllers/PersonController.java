package com.yazukov.tests.controllers;

import com.yazukov.tests.dto.person.PersonDto;
import com.yazukov.tests.services.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("/all")
    public List<PersonDto> showAllPersons(){
        return personService.getAllPersons();
    }
}
