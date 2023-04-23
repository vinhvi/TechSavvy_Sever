package com.example.techsavvy.serviceIpml;

import com.example.techsavvy.entity.Address;
import com.example.techsavvy.repository.AddressRepository;
import com.example.techsavvy.service.AddressService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AddressImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address getById(int id) {
        return addressRepository.findById(id);
    }

    @Override
    public int saveAndReturnId(Address address) {
        return save(address).getId();
    }
}
