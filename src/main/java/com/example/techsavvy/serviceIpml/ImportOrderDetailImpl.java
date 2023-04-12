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
    public List<ImportOrderDetail> getListByImportOrderId(int id) {
        List<ImportOrderDetail> importOrderDetails = importOrderDetailRepository.findByImportOrder_Id(id);
        List<ImportOrderDetail> importOrderDetailList = new ArrayList<>();
        ImportOrderDetail importOrderDetail1 = new ImportOrderDetail();
        for (ImportOrderDetail importOrderDetail : importOrderDetails) {
            ImportOrder importOrder = new ImportOrder();
            importOrder.setId(importOrderDetail.getImportOrder().getId());
            Product product = new Product();
            product.setId(importOrderDetail.getProduct().getId());
            importOrderDetail1.setId(importOrderDetail.getId());
            importOrderDetail1.setImportOrder(importOrder);
            importOrderDetail1.setProduct(product);
            importOrderDetailList.add(importOrderDetail1);
        }
        return importOrderDetailList;
    }
}
