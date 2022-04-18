package com.yazukov.tests.services.person.impl;

import com.yazukov.tests.dto.person.PassportDto;
import com.yazukov.tests.dto.person.PersonDto;
import com.yazukov.tests.dto.person.RegAddressDto;
import com.yazukov.tests.model.person.Person;
import com.yazukov.tests.repositories.person.PersonRepository;
import com.yazukov.tests.services.person.PassportService;
import com.yazukov.tests.services.person.PersonService;
import com.yazukov.tests.services.person.RegAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PassportService passportService;
    @Autowired
    private RegAddressService regAddressService;

    @Override
    public List<PersonDto> getAllPersons() {
        List<Person> persons = personRepository.findAll();
        List<Person> result = persons.stream()
                .filter(person -> person.isDeleted()==false).collect(Collectors.toList());
        return mapListPersonsToDto(result);
    }

    private List<PersonDto> mapListPersonsToDto(List<Person> persons) {
        return persons.stream().map(person -> {
            return mapPersonToDto(person);
        }).collect(Collectors.toList());
    }

    private PersonDto mapPersonToDto(Person person) {
        PersonDto personDto = new PersonDto();

        personDto.setFirstName(person.getFirstName());
        personDto.setLastName(person.getLastName());
        personDto.setPatronymic(person.getPatronymic());
        personDto.setBirthDate(person.getBirthDate());

        List<PassportDto> passports = passportService.getAllPassportByPerson(person.getId());
        personDto.setPassports(passports);

        List<RegAddressDto> regAddresses = regAddressService.getAllRegAddressesByPerson(person.getId());
        personDto.setRegAddresses(regAddresses);

        return personDto;
    }
}
