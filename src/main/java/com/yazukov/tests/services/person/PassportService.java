package com.yazukov.tests.services.person;

import com.yazukov.tests.dto.person.PassportDto;

import java.util.List;

public interface PassportService {
    List<PassportDto> getAllPassportByPerson(Long personId);
}
