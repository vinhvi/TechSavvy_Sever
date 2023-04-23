package com.example.techsavvy.repository;

import com.example.techsavvy.entity.ImportOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImportOrderRepository extends JpaRepository<ImportOrder, String> {
    ImportOrder findImportOrderById(String id);
}
