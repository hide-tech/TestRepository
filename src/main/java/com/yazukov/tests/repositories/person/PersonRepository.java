package com.yazukov.tests.repositories.person;

import com.yazukov.tests.model.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
