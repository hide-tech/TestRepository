package com.yazukov.tests.repositories.security;

import com.yazukov.tests.model.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
