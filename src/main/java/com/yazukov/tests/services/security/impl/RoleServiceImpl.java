package com.yazukov.tests.services.security.impl;

import com.yazukov.tests.repositories.security.RoleRepository;
import com.yazukov.tests.services.security.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
}
