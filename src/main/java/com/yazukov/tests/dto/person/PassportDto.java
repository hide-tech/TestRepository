package com.yazukov.tests.dto.person;

import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PassportDto {
    private String identificationNumber;
    private String passportNumber;
    private LocalDate issueDate;
    private LocalDate expireDate;
    private String authority;
}
