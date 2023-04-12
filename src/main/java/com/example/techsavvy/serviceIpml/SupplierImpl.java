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
    public void delete(int id) {
        Supplier supplier = getById(id);
        supplier.setStatus(false);
        supplierRepository.save(supplier);
    }

    @Override
    public Supplier getById(int id) {
        Supplier supplier = supplierRepository.findById(id);
        return getOne(supplier);
    }

    @Override
    public Supplier getByPhone(String phone) {
        Supplier supplier = supplierRepository.findByPhone(phone);
        return getOne(supplier);
    }

    @Override
    public Supplier getByEmail(String email) {
        Supplier supplier = supplierRepository.findByEmail(email);
        return getOne(supplier);
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
        List<Supplier> suppliers = supplierRepository.findAll();
        List<Supplier> supplierList = new ArrayList<>();
        Supplier supplier;
        for (Supplier supplier1 : suppliers) {
            supplier = getOne(supplier1);
            supplierList.add(supplier);
        }
        return supplierList;
    }
}
