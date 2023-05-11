package com.example.techsavvy.service;

import com.example.techsavvy.entity.Cart;

public interface CartService {
    Cart createCart(Cart cart);
    Cart getByCustomerEmail(String email);


}
