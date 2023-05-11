package com.example.techsavvy.serviceIpml;

import com.example.techsavvy.entity.Cart;
import com.example.techsavvy.entity.Customer;
import com.example.techsavvy.repository.CartRepository;
import com.example.techsavvy.repository.CustomerRepository;
import com.example.techsavvy.service.CartService;
import com.example.techsavvy.service.CustomerService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CartImpl implements CartService {
    private final CartRepository cartRepository;
    private final CustomerService customerService;
    @Override
    public Cart createCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Cart getByCustomerId(String email) {
        Cart cart = cartRepository.findCartByCustomerId(email);
        if (cart == null) {
            Customer customer = customerService.getByEmail(email);
            if (customer != null) {
                Date date = new Date();
                cart.setCustomer(customer);
                cart.setImportDate(date);
                return cartRepository.save(cart);
            } else {
                throw new RuntimeException("Không tìm thấy khách hàng!!");
            }
        }
        return cart;
    }

}
