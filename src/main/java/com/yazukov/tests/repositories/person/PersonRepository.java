package com.yazukov.tests.repositories.person;

import com.yazukov.tests.model.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Transactional(readOnly = true)
    @Query(nativeQuery = true, value = "select * from persons p left join " +
            "passports pp on p.id=pp.person_id left join reg_address ra on p.id=ra.person_id")
    List<Person> getAllPersonsWithData();

    @Transactional(readOnly = true)
    @Query(nativeQuery = true, value = "select * from persons p where p.deleted=false")
    List<Person> findAllFiltered();
}
