package com.yazukov.tests.services.person.impl;

import com.yazukov.tests.dto.person.RegAddressDto;
import com.yazukov.tests.model.person.Person;
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

    public List<RegAddressDto> mapListRegAddressToDto(List<RegAddress> addresses) {
        return addresses.stream().map(address -> {
            return mapRegAddressToDto(address);
        }).collect(Collectors.toList());
    }

    public RegAddressDto mapRegAddressToDto(RegAddress address) {
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

    @Override
    public List<RegAddress> saveAndChainAddressesToPerson(List<RegAddressDto> regAddressDtoList, Person person) {
        List<RegAddress> addresses = regAddressDtoList.stream().map(addressDto ->{
            return mapDtoToRegAddress(addressDto, person);
        }).collect(Collectors.toList());
        return addresses.stream().peek(address -> regAddressRepository.save(address)).collect(Collectors.toList());
    }

    @Override
    public void deleteRegAddresses(List<RegAddress> addresses) {
        addresses.stream().forEach(address -> {
            address.setDeleted(true);
            regAddressRepository.save(address);
        });
    }

    private RegAddress mapDtoToRegAddress(RegAddressDto addressDto, Person person) {
        RegAddress address = new RegAddress();

        address.setIndex(addressDto.getIndex());
        address.setCountry(addressDto.getCountry());
        address.setCity(addressDto.getCity());
        address.setStreet(addressDto.getStreet());
        address.setBuilding(addressDto.getBuilding());
        address.setExtension(addressDto.getExtension());
        address.setOffice(addressDto.getOffice());
        address.setBeginDate(addressDto.getBeginDate());
        address.setExpireDate(addressDto.getExpireDate());
        address.setDeleted(false);
        address.setPerson(person);

        return address;
    }
}
