package com.yazukov.tests.services.person.impl;

import com.yazukov.tests.dto.person.RegAddressDto;
import com.yazukov.tests.model.person.RegAddress;
import com.yazukov.tests.repositories.person.RegAddressRepository;
import com.yazukov.tests.services.person.RegAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegAddressServiceImpl implements RegAddressService {
    @Autowired
    private RegAddressRepository regAddressRepository;

    @Override
    public List<RegAddressDto> getAllRegAddressesByPerson(Long personId) {
        List<RegAddress> addresses = regAddressRepository.findMyPersonId(personId);
        return mapListRegAddressToDto(addresses);
    }

    private List<RegAddressDto> mapListRegAddressToDto(List<RegAddress> addresses) {
        return addresses.stream().map(address -> {
            return mapRegAddressToDto(address);
        }).collect(Collectors.toList());
    }

    private RegAddressDto mapRegAddressToDto(RegAddress address) {
        RegAddressDto regAddressDto = new RegAddressDto();

        regAddressDto.setIndex(address.getIndex());
        regAddressDto.setCountry(address.getCountry());
        regAddressDto.setCity(address.getCity());
        regAddressDto.setStreet(address.getStreet());
        regAddressDto.setBuilding(address.getBuilding());
        regAddressDto.setExtension(address.getExtension());
        regAddressDto.setOffice(address.getOffice());
        regAddressDto.setBeginDate(address.getBeginDate());
        regAddressDto.setExpireDate(address.getExpireDate());

        return regAddressDto;
    }
}
