package com.example.techsavvy.service;

import com.example.techsavvy.entity.Payments;

import java.util.List;

public interface PaymentService {

    Payments add(Payments payments);

    List<Payments> getListPayments();

    Payments getById(int id);
}
