package com.yazukov.tests.services.security;

import com.yazukov.tests.model.security.User;

public interface UserService {

    User getUserByUsername(String username);

}
