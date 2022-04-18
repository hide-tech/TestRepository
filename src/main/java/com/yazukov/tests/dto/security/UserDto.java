package com.yazukov.tests.dto.security;

import lombok.Data;

@Data
public class UserDto {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
}
