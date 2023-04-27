package com.example.techsavvy.service;

import com.example.techsavvy.entity.Options;
import com.example.techsavvy.entity.Product;

import java.util.List;

public interface OptionsService {
    Options save(Options options);

    Options getById(int id);
    List<Options> getOptionsByProduct(String productId);

    Options updateOptions(Options options);



}
