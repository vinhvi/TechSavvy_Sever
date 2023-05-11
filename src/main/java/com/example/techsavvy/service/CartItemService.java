package com.example.techsavvy.service;

import com.example.techsavvy.entity.CartItems;

public interface CartItemService {
    CartItems create(CartItems cartItems);

    void deleteCartItem(int id);
}
