package com.example.techsavvy.serviceIpml;

import com.example.techsavvy.entity.Discount;
import com.example.techsavvy.repository.DiscountRepository;
import com.example.techsavvy.service.DiscountService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class DiscountImpl implements DiscountService {

    private final DiscountRepository discountRepository;

    @Override
    public Discount createDiscount(Discount discount) {
        return discountRepository.save(discount);
    }

    @Override
    public Discount getById(String id) {
        return discountRepository.findDiscountById(id);
    }

    @Override
    public List<Discount> getListDiscount() {
        return discountRepository.findAll();
    }

    @Override
    public String randomIdDiscount() {
        Random random = new Random();
        String id = "";
        boolean check = false;
        int attempts = 0;
        int maxAttempts = 10000; // set a maximum number of attempts to prevent infinite loop
        while (!check && attempts < maxAttempts) {
            int number = random.nextInt(10000);
            id = "SALE" + String.format("%04d", number);
            if (discountRepository.findDiscountById(id) == null) {
                check = true;
            }
            attempts++;
        }
        if (!check) {
            throw new RuntimeException("Unable to generate a unique ID after " + maxAttempts + " attempts.");
        }
        return id;

    }


}
