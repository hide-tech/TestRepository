package com.yazukov.tests.services.person.impl;

import com.yazukov.tests.dto.person.PassportDto;
import com.yazukov.tests.model.person.Passport;
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

    private List<PassportDto> mapListPassportToDto(List<Passport> passports) {
        return passports.stream().map(passport -> {
            return mapPassportToDto(passport);
        }).collect(Collectors.toList());
    }

    private PassportDto mapPassportToDto(Passport passport) {
        PassportDto passportDto = new PassportDto();

        passportDto.setIdentificationNumber(passport.getIdentificationNumber());
        passportDto.setPassportNumber(passport.getPassportNumber());
        passportDto.setIssueDate(passport.getIssueDate());
        passportDto.setExpireDate(passport.getExpireDate());
        passportDto.setAuthority(passport.getAuthority());

        return passportDto;
    }
}
