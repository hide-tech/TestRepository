package com.yazukov.tests.services.person;

import com.yazukov.tests.dto.person.PersonDto;
import com.yazukov.tests.model.person.Person;

import java.util.List;

public interface PersonService {
    List<PersonDto> getAllPersons();

    List<PersonDto> getAllByOneQuery();

    PersonDto getPersonByIdOneQ(Long personId);

    Person createNewPerson(PersonDto personDto);

    Person deletePerson(Long personId);

    List<PersonDto> getAllFiltered();

}
