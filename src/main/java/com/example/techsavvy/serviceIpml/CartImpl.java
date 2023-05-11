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
    private final CustomerRepository customerRepository;
    @Override
    public Cart createCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Cart getByCustomerEmail(String email) {
        Cart cart = cartRepository.findCartByCustomerId(email);
        if (cart != null) {
            return cart;
        } else {
            Customer customer = customerRepository.findCustomerByEmail(email);
            if (customer == null) {
                throw new RuntimeException("Không tìm thấy khách hàng!!");
            } else {
                Cart newCart = new Cart();
                Date date = new Date();
                newCart.setCustomer(customer);
                newCart.setImportDate(date);
                return cartRepository.save(newCart);
            }
        }
    }

}
