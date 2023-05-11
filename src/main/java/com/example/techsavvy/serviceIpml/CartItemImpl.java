package com.example.techsavvy.serviceIpml;

import com.example.techsavvy.entity.CartItems;
import com.example.techsavvy.repository.CartItemRepository;
import com.example.techsavvy.service.CartItemService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CartItemImpl implements CartItemService {
    private final CartItemRepository cartItemRepository;

    @Override
    public CartItems create(CartItems cartItems) {
        return cartItemRepository.save(cartItems);
    }

    @Override
    public void deleteCartItem(int id) {
        cartItemRepository.deleteById(id);
    }
}
