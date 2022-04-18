package com.yazukov.tests.repositories.person;

import com.yazukov.tests.model.person.Passport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassportRepository extends JpaRepository<Passport, Long> {
}
