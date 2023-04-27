package com.example.techsavvy.serviceIpml;

import com.example.techsavvy.entity.ImportOrder;
import com.example.techsavvy.entity.ImportOrderDetail;
import com.example.techsavvy.entity.Product;
import com.example.techsavvy.repository.ImportOrderDetailRepository;
import com.example.techsavvy.service.ImportDetailService;
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
public class ImportOrderDetailImpl implements ImportDetailService {

    private final ImportOrderDetailRepository importOrderDetailRepository;

    @Override
    public ImportOrderDetail save(ImportOrderDetail importOrderDetail) {
        return importOrderDetailRepository.save(importOrderDetail);
    }

    @Override
    public List<ImportOrderDetail> getListByImportOrderId(String id) {
        return importOrderDetailRepository.findByImportOrder_Id(id);
    }
}
