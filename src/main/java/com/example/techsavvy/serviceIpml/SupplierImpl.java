package com.example.techsavvy.serviceIpml;

import com.example.techsavvy.entity.Supplier;
import com.example.techsavvy.repository.SupplierRepository;
import com.example.techsavvy.service.SupplierService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class SupplierImpl implements SupplierService {
    private final SupplierRepository supplierRepository;

    @Override
    public Supplier save(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public Supplier update(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public void delete(String id) {
        Supplier supplier = supplierRepository.findSupplierById(id);
        supplier.setStatus(false);
        supplierRepository.save(supplier);
    }

    @Override
    public String generateId() {
        Random random = new Random();
        String newId = "";
        boolean check = false;
        int attempts = 0;
        int maxAttempts = 10000; // set a maximum number of attempts to prevent infinite loop
        while (!check && attempts < maxAttempts){
            int number = random.nextInt(10000);
            newId = "NCC" + String.format("%04d", number);
            if (supplierRepository.findSupplierById(newId) == null){
                check = true;
            }
            attempts++;
        }
        if (!check) {
            throw new RuntimeException("Unable to generate a unique ID after " + maxAttempts + " attempts.");
        }
        return newId;
    }

    @Override
    public Supplier getById(String id) {
        return supplierRepository.findSupplierById(id);
    }

    @Override
    public Supplier getByPhone(String phone) {
        return supplierRepository.findByPhone(phone);
    }

    @Override
    public Supplier getByEmail(String email) {
        return supplierRepository.findByEmail(email);
    }

    @Override
    public Supplier getOne(Supplier supplier) {
        Supplier supplier1 = new Supplier();
        supplier1.setName(supplier.getName());
        supplier1.setEmail(supplier.getEmail());
        supplier1.setAddress(supplier.getAddress());
        supplier1.setPhone(supplier.getPhone());
        supplier1.setStatus(supplier.isStatus());
        supplier1.setId(supplier.getId());
        return supplier1;
    }

    @Override
    public List<Supplier> getAll() {
        return supplierRepository.findAll();
    }
}
