package com.example.techsavvy.service;

import com.example.techsavvy.entity.ShippingCompany;

import java.util.List;

public interface ShippingCompanyService {

    ShippingCompany add(ShippingCompany shippingCompany);

    ShippingCompany getById(int id);

    ShippingCompany getByEmailOrPhone(String value);

    ShippingCompany update(ShippingCompany shippingCompany);

    List<ShippingCompany> getList();

}
