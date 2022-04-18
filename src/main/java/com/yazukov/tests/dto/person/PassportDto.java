package com.yazukov.tests.dto.person;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PassportDto {
    private String identificationNumber;
    private String passportNumber;
    private LocalDate issueDate;
    private LocalDate expireDate;
    private String authority;
}
