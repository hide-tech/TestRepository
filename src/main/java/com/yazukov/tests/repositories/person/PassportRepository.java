package com.yazukov.tests.repositories.person;

import com.yazukov.tests.model.person.Passport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassportRepository extends JpaRepository<Passport, Long> {

    @Query(name = "Passports.findAllPassportsByPersonId",
            value = "SELECT p FROM Passport p WHERE Passport.person.id = :personId")
    List<Passport> findAllByPersonId(Long personId);
}
