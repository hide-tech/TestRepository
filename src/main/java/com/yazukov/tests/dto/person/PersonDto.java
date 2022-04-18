package com.yazukov.tests.dto.person;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class PersonDto {
    private String firstName;
    private String lastName;
    private String patronymic;
    private LocalDate birthDate;
    private List<PassportDto> passports;
    private List<RegAddressDto> regAddresses;
}
