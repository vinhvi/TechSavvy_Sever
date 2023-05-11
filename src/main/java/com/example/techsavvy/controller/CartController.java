package com.example.techsavvy.controller;

import com.example.techsavvy.entity.Cart;
import com.example.techsavvy.entity.CartItems;
import com.example.techsavvy.service.CartItemService;
import com.example.techsavvy.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cart")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CartController {
    private final CartService cartService;
    private final CartItemService cartItemService;

    @PostMapping("/createNewCart")
    public ResponseEntity<?> createCart(@RequestBody Cart newCart) {
        Cart check = cartService.getByCustomerId(newCart.getCustomer().getId());
        if (check.getCartItems().isEmpty()) {
            return ResponseEntity.ok().body(cartService.createCart(newCart));
        }
        return ResponseEntity.status(409).body("Khách Hàng đã có giỏ hàng !!s");
    }

    @GetMapping("getCartByCustomerId/{customer_id}")
    public ResponseEntity<?> getByCustomerId(@PathVariable("customer_id") String customer_id) {
        Cart cart = cartService.getByCustomerId(customer_id);
        if (cart.getCartItems().isEmpty()) {
            return ResponseEntity.ok().body("Giỏ đồ mày chưa có cái lol j cả dmm!!");
        }
        return ResponseEntity.ok().body(cartService.getByCustomerId(customer_id));
    }

    @PostMapping("/createNewCartItems")
    public ResponseEntity<CartItems> createCartItem(@RequestBody CartItems newCartItems) {
        return ResponseEntity.ok().body(cartItemService.create(newCartItems));
    }

    @DeleteMapping("/deleteCartItem/{cartItem_id}")
    public ResponseEntity<?> deleteCartItemById(@PathVariable("cartItem_id") int cartItem_id) {
        cartItemService.deleteCartItem(cartItem_id);
        return ResponseEntity.ok().body("đã xóa!!");
    }
}
