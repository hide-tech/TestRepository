package com.yazukov.tests.services.person;

import com.yazukov.tests.dto.person.PersonDto;

import java.util.List;

public interface PersonService {
    List<PersonDto> getAllPersons();
}
