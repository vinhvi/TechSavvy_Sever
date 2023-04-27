package com.example.techsavvy.service;

import com.example.techsavvy.entity.ImportOrder;

import java.util.List;

public interface ImportService {
    ImportOrder save(ImportOrder importOrder);
    String generateId();

    List<ImportOrder> getAllImportOrder();

}
