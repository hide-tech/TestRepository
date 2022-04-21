package com.yazukov.tests.services.person.impl;

import com.yazukov.tests.dto.person.PassportDto;
import com.yazukov.tests.model.person.Passport;
import com.yazukov.tests.model.person.Person;
import com.yazukov.tests.repositories.person.PassportRepository;
import com.yazukov.tests.services.person.PassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PassportServiceImpl implements PassportService {
    @Autowired
    private PassportRepository passportRepository;

    @Override
    public List<PassportDto> getAllPassportByPerson(Long personId) {
        List<Passport> passports = passportRepository.findMyByPersonId(personId);
        return mapListPassportToDto(passports);
    }

    public List<PassportDto> mapListPassportToDto(List<Passport> passports) {
        return passports.stream().map(passport -> {
            return mapPassportToDto(passport);
        }).collect(Collectors.toList());
    }

    public PassportDto mapPassportToDto(Passport passport) {
        PassportDto passportDto = new PassportDto();

        passportDto.setIdentificationNumber(passport.getIdentificationNumber());
        passportDto.setPassportNumber(passport.getPassportNumber());
        passportDto.setIssueDate(passport.getIssueDate());
        passportDto.setExpireDate(passport.getExpireDate());
        passportDto.setAuthority(passport.getAuthority());

        return passportDto;
    }

    @Override
    public List<Passport> saveAndChainPassportsToPerson(List<PassportDto> passportDtoList, Person person) {
        List<Passport> passports = passportDtoList.stream().map(passportDto -> {
            return convertDtoToPassport(passportDto, person);
        }).collect(Collectors.toList());
        return passports.stream().peek(passport -> passportRepository.save(passport)).collect(Collectors.toList());
    }

    @Override
    public void deletePassports(List<Passport> passports) {
        passports.stream().forEach(passport -> {
            passport.setDeleted(true);
            passportRepository.save(passport);
        });
    }

    private Passport convertDtoToPassport(PassportDto passportDto, Person person) {
        Passport passport = new Passport();

        passport.setIdentificationNumber(passportDto.getIdentificationNumber());
        passport.setPassportNumber(passportDto.getPassportNumber());
        passport.setAuthority(passportDto.getAuthority());
        passport.setIssueDate(passportDto.getIssueDate());
        passport.setExpireDate(passportDto.getExpireDate());
        passport.setDeleted(false);
        passport.setPerson(person);

        return passport;
    }
}
