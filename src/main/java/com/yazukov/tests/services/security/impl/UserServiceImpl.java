package com.yazukov.tests.services.security.impl;

import com.yazukov.tests.repositories.security.UserRepository;
import com.yazukov.tests.services.security.RoleService;
import com.yazukov.tests.services.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleService roleService;
}
