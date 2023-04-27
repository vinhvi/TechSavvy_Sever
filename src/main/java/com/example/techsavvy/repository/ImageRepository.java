package com.example.techsavvy.repository;


import com.example.techsavvy.entity.Image;
import com.example.techsavvy.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, String> {
    Image findImageById(String id);

    List<Image> findImageByProductId(String productId);
}
