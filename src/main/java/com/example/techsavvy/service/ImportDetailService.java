package com.example.techsavvy.service;

import com.example.techsavvy.entity.ImportOrder;
import com.example.techsavvy.entity.ImportOrderDetail;

import java.util.List;

public interface ImportDetailService {
   ImportOrderDetail save(ImportOrderDetail importOrderDetail);
   List<ImportOrderDetail> getListByImportOrderId(int id);

}
