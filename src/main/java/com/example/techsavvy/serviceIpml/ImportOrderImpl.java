package com.example.techsavvy.serviceIpml;

import com.example.techsavvy.entity.ImportOrder;
import com.example.techsavvy.repository.ImportOrderDetailRepository;
import com.example.techsavvy.repository.ImportOrderRepository;
import com.example.techsavvy.service.ImportService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
}
