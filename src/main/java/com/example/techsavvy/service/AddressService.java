package com.example.techsavvy.service;

import com.example.techsavvy.entity.Address;

import java.util.UUID;

public interface AddressService {
    Address save(Address address);
    Address getById(int id);

    int saveAndReturnId(Address address);
}
