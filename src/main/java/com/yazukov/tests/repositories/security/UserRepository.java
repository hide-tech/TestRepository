package com.yazukov.tests.repositories.security;

import com.yazukov.tests.model.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
