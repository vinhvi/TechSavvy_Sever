package com.example.techsavvy.service;

import com.example.techsavvy.entity.Discount;

import java.util.List;

public interface DiscountService {
    Discount createDiscount(Discount discount);
    Discount getById(String id);
    List<Discount> getListDiscount();

    String randomIdDiscount();
}
