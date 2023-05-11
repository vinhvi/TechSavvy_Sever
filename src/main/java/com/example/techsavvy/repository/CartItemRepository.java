package com.example.techsavvy.repository;

import com.example.techsavvy.entity.CartItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItems, Integer> {
    List<CartItems> findCartItemsByCartId(int cart_id);

}
