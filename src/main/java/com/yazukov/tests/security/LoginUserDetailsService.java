package com.yazukov.tests.security;

import com.yazukov.tests.model.security.User;
import com.yazukov.tests.services.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserByUsername(username);

        if (user == null){
            throw new UsernameNotFoundException(String.format("User with username: %s not found", username));
        }

        LoginUserDetails loginUserDetails = LoginUserDetailsFactory.createLoginUserDetails(user);
        return loginUserDetails;
    }
}
