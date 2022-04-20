package com.yazukov.tests.security;

import com.yazukov.tests.model.security.Role;
import com.yazukov.tests.model.security.Status;
import com.yazukov.tests.model.security.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.stream.Collectors;

public class LoginUserDetailsFactory {

    public LoginUserDetailsFactory(){
    }

    public static LoginUserDetails createLoginUserDetails(User user){
        return new LoginUserDetails(user.getFirstName(),
                                    user.getLastName(),
                                    user.getUsername(),
                                    user.getPassword(),
                                    user.getEmail(),
                                    user.getStatus().equals(Status.ACTIVE),
                                    mapToGrantedAuthorities(user.getRoles()));
    }

    private static Collection<? extends GrantedAuthority> mapToGrantedAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

}
