package com.yazukov.tests.dto.person;

import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RegAddressDto {
    private String index;
    private String country;
    private String city;
    private String street;
    private String building;
    private String extension;
    private String office;
    private LocalDate beginDate;
    private LocalDate expireDate;
}
