package com.yazukov.tests.services.person;

import com.yazukov.tests.dto.person.PassportDto;
import com.yazukov.tests.model.person.Passport;
import com.yazukov.tests.model.person.Person;

import java.util.List;

public interface PassportService {
    List<PassportDto> getAllPassportByPerson(Long personId);

    List<PassportDto> mapListPassportToDto(List<Passport> passports);

    PassportDto mapPassportToDto(Passport passport);

    List<Passport> saveAndChainPassportsToPerson(List<PassportDto> passportDtoList, Person person);

    void deletePassports(List<Passport> passports);
}
