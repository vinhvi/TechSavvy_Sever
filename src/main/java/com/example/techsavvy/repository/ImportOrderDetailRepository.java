package com.example.techsavvy.repository;

import com.example.techsavvy.entity.ImportOrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImportOrderDetailRepository extends JpaRepository<ImportOrderDetail, Integer> {
    List<ImportOrderDetail> findByImportOrder_Id(String id);

}
