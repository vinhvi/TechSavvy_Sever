package com.example.techsavvy.service;

import com.example.techsavvy.entity.ShippingCompany;

public interface ShippingCompanyService {

    ShippingCompany add(ShippingCompany shippingCompany);

    ShippingCompany getById(int id);

    ShippingCompany getByEmailOrPhone(String value);

    ShippingCompany update(ShippingCompany shippingCompany);

    ShippingCompany getOne(ShippingCompany shippingCompany);
}
