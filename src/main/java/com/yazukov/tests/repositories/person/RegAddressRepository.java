package com.yazukov.tests.repositories.person;

import com.yazukov.tests.model.person.RegAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegAddressRepository extends JpaRepository<RegAddress, Long> {

    @Query(name = "RegAddress.findAllPassportsByPersonId",
            value = "SELECT r FROM RegAddress r WHERE RegAddress.person.id = :personId")
    List<RegAddress> findAllPersonId(Long personId);
}
