package com.example.techsavvy.service;

import com.example.techsavvy.entity.Supplier;

import java.util.List;
import java.util.Optional;

public interface SupplierService {
    Supplier save(Supplier supplier);

    Supplier update(Supplier supplier);

    void delete(String id);
    String generateId();

   Supplier getById(String id);

    Supplier getByPhone(String phone);

    Supplier getByEmail(String email);

    Supplier getOne(Supplier supplier);

    List<Supplier> getAll();
}
