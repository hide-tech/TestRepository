package com.yazukov.tests.repositories.person;

import com.yazukov.tests.model.person.RegAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegAddressRepository extends JpaRepository<RegAddress, Long> {
}
