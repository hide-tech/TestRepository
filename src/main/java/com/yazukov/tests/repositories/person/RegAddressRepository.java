package com.yazukov.tests.repositories.person;

import com.yazukov.tests.model.person.RegAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface RegAddressRepository extends JpaRepository<RegAddress, Long> {

    @Transactional(readOnly = true)
    @Query(nativeQuery = true, value = "select * from reg_address r where r.person_id = :personId")
    List<RegAddress> findMyPersonId(Long personId);
}
