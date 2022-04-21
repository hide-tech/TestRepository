package com.yazukov.tests.services.person.impl;

import com.yazukov.tests.dto.person.PassportDto;
import com.yazukov.tests.dto.person.PersonDto;
import com.yazukov.tests.dto.person.RegAddressDto;
import com.yazukov.tests.model.person.Passport;
import com.yazukov.tests.model.person.Person;
import com.yazukov.tests.model.person.RegAddress;
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

    @Override
    public List<PersonDto> getAllByOneQuery() {
        List<Person> persons = personRepository.getAllPersonsWithData();
        List<Person> result = persons.stream()
                .filter(person -> person.isDeleted()==false).collect(Collectors.toList());
        return mapListPersonsToDtoOneQuery(result);
    }

    @Override
    public PersonDto getPersonByIdOneQ(Long personId) {
        Person person = personRepository.getById(personId);
        if (person.isDeleted() || person==null) return null;
        return mapPersonToDtoOneQuery(person);
    }

    @Override
    public Person createNewPerson(PersonDto personDto) {
        List<RegAddressDto> addressDtoList = personDto.getRegAddresses();

        List<PassportDto> passportDtoList = personDto.getPassports();
        return personRepository.save(mapDtoToPerson(personDto));
    }

    @Override
    public Person deletePerson(Long personId) {
        Person person = personRepository.getById(personId);
        if (person==null)
            return null;
        person.setDeleted(true);
        List<Passport> passports = person.getPassports();
        passportService.deletePassports(passports);
        List<RegAddress> addresses = person.getAddresses();
        regAddressService.deleteRegAddresses(addresses);
        person = personRepository.save(person);
        return person;
    }

    @Override
    public List<PersonDto> getAllFiltered() {
        List<Person> persons = personRepository.findAllFiltered();
        return mapListPersonsToDto(persons);
    }

    private Person mapDtoToPerson(PersonDto personDto) {
        Person person = new Person();

        person.setFirstName(personDto.getFirstName());
        person.setLastName(personDto.getLastName());
        person.setPatronymic(personDto.getPatronymic());
        person.setBirthDate(personDto.getBirthDate());
        person.setDeleted(false);
        Person result = personRepository.save(person);

        List<PassportDto> passportDtoList = personDto.getPassports();
        List<Passport> passports = passportService.saveAndChainPassportsToPerson(passportDtoList,result);
        result.setPassports(passports);

        List<RegAddressDto> regAddressDtoList = personDto.getRegAddresses();
        List<RegAddress> addresses = regAddressService.saveAndChainAddressesToPerson(regAddressDtoList,result);
        result.setAddresses(addresses);

        return result;
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

    private List<PersonDto> mapListPersonsToDtoOneQuery(List<Person> result) {
        return result.stream().map(person -> {
            return mapPersonToDtoOneQuery(person);
        }).collect(Collectors.toList());
    }

    private PersonDto mapPersonToDtoOneQuery(Person person) {
        PersonDto personDto = new PersonDto();

        personDto.setFirstName(person.getFirstName());
        personDto.setLastName(person.getLastName());
        personDto.setPatronymic(person.getPatronymic());
        personDto.setBirthDate(person.getBirthDate());

        List<Passport> passports = person.getPassports();
        passports.stream().filter(passport -> passport.isDeleted()).collect(Collectors.toList());
        List<PassportDto> passportDtoList = passportService.mapListPassportToDto(passports);
        personDto.setPassports(passportDtoList);
        List<RegAddress> addresses = person.getAddresses();
        addresses.stream().filter(address -> address.isDeleted()).collect(Collectors.toList());
        List<RegAddressDto> addressDtoList = regAddressService.mapListRegAddressToDto(addresses);
        personDto.setRegAddresses(addressDtoList);

        return personDto;
    }
}
