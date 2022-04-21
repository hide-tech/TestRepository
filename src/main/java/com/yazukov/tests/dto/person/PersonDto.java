package com.yazukov.tests.dto.person;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PersonDto {
    private String firstName;
    private String lastName;
    private String patronymic;
    private LocalDate birthDate;
    private List<PassportDto> passports;
    private List<RegAddressDto> regAddresses;
}
