package com.example.techsavvy.service;

import com.example.techsavvy.entity.Supplier;

import java.util.List;

public interface SupplierService {
    Supplier save(Supplier supplier);

    Supplier update(Supplier supplier);

    void delete(int id);

    Supplier getById(int id);

    Supplier getByPhone(String phone);

    Supplier getByEmail(String email);

    Supplier getOne(Supplier supplier);

    List<Supplier> getAll();
}
