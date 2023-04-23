package com.example.techsavvy.serviceIpml;

import com.example.techsavvy.entity.ImportOrder;
import com.example.techsavvy.entity.Product;
import com.example.techsavvy.repository.ImportOrderDetailRepository;
import com.example.techsavvy.repository.ImportOrderRepository;
import com.example.techsavvy.service.ImportService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ImportOrderImpl implements ImportService {
    private final ImportOrderRepository importOrderRepository;

    @Override
    public ImportOrder save(ImportOrder importOrder) {
        return importOrderRepository.save(importOrder);
    }

    @Override
    public String generateId() {
        Random random = new Random();
        String newId = "";
        boolean check = false;
        int attempts = 0;
        int maxAttempts = 10000; // set a maximum number of attempts to prevent infinite loop
        while (!check && attempts < maxAttempts) {
            int number = random.nextInt(10000);
            newId = "HDNH" + String.format("%04d", number);
            if (importOrderRepository.findImportOrderById(newId) == null) {
                check = true;
            }
            attempts++;
        }
        if (!check) {
            throw new RuntimeException("Unable to generate a unique ID after " + maxAttempts + " attempts.");
        }
        return newId;
    }

}
