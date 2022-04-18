package com.yazukov.tests.services.person;

import com.yazukov.tests.dto.person.RegAddressDto;

import java.util.List;

public interface RegAddressService {
    List<RegAddressDto> getAllRegAddressesByPerson(Long personId);
}
