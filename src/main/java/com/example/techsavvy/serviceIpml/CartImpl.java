package com.example.techsavvy.serviceIpml;

import com.example.techsavvy.entity.Cart;
import com.example.techsavvy.repository.CartRepository;
import com.example.techsavvy.service.CartService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CartImpl implements CartService {
    private final CartRepository cartRepository;

    @Override
    public Cart createCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Cart getByCustomerId(String id) {
        return cartRepository.findCartByCustomerId(id);
    }

}
