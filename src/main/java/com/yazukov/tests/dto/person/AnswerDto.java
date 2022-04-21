package com.yazukov.tests.dto.person;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AnswerDto {
    private String created = "Successfully";
    private Long id;
    private String lastName;
}
