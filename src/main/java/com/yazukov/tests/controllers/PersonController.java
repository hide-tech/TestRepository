package com.yazukov.tests.controllers;

import com.yazukov.tests.dto.person.AnswerDto;
import com.yazukov.tests.dto.person.PersonDto;
import com.yazukov.tests.model.person.Person;
import com.yazukov.tests.services.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/query")
    public List<PersonDto> showAllByOneQuery() {return personService.getAllByOneQuery(); }

    @GetMapping("/filter")
    public List<PersonDto> showAllFilteredPerson(){
        return personService.getAllFiltered();
    }

    @GetMapping("/{id}")
    public PersonDto showPersonById(@PathVariable("id") Long id){
        return personService.getPersonByIdOneQ(id);
    }

    @PostMapping
    public AnswerDto addNewPerson(@RequestBody PersonDto personDto){
        Person person = personService.createNewPerson(personDto);
        AnswerDto answer = new AnswerDto();
        if (person==null){
            answer.setCreated("something wrong");
            answer.setId(null);
            answer.setLastName(personDto.getLastName());
        } else {
            answer.setId(person.getId());
            answer.setLastName(person.getLastName());
            answer.setCreated("successfully created");
        }
        return answer;
    }

    @DeleteMapping("/{id}")
    public AnswerDto removePerson(@PathVariable("id") Long personId){
        Person person = personService.deletePerson(personId);
        AnswerDto answer = new AnswerDto();
        if (person==null){
            answer.setCreated("Person with id couldn't found");
            answer.setId(personId);
            answer.setLastName("not found");
        } else {
            answer.setCreated("Successfully deleted");
            answer.setId(personId);
            answer.setLastName(person.getLastName());
        }
        return answer;
    }
}
