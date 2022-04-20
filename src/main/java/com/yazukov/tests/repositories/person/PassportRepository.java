package com.yazukov.tests.repositories.person;

import com.yazukov.tests.model.person.Passport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PassportRepository extends JpaRepository<Passport, Long> {

    @Transactional(readOnly = true)
    @Query(nativeQuery = true, value = "select * from passports p where p.person_id = :personId")
    List<Passport> findMyByPersonId(Long personId);
}
