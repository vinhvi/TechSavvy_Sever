package com.example.techsavvy.serviceIpml;

import com.example.techsavvy.entity.Payments;
import com.example.techsavvy.repository.PaymentRepository;
import com.example.techsavvy.service.PaymentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class PaymentImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Override
    public Payments add(Payments payments) {
        return paymentRepository.save(payments);
    }

    @Override
    public List<Payments> getListPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payments getById(int id) {
        return paymentRepository.findById(id);
    }
}
