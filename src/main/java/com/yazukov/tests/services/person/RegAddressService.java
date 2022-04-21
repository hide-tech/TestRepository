package com.yazukov.tests.services.person;

import com.yazukov.tests.dto.person.RegAddressDto;
import com.yazukov.tests.model.person.Person;
import com.yazukov.tests.model.person.RegAddress;

import java.util.List;

public interface RegAddressService {
    List<RegAddressDto> getAllRegAddressesByPerson(Long personId);

    List<RegAddressDto> mapListRegAddressToDto(List<RegAddress> addresses);

    RegAddressDto mapRegAddressToDto(RegAddress address);

    List<RegAddress> saveAndChainAddressesToPerson(List<RegAddressDto> regAddressDtoList, Person person);

    void deleteRegAddresses(List<RegAddress> addresses);
}
