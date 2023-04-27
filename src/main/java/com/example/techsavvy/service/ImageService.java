package com.example.techsavvy.service;


import com.example.techsavvy.entity.Image;
import com.example.techsavvy.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ImageService {
    Image addImage(Image image);

    void delete(String id);

    Optional<Optional<Image>> getOne(String id);

    boolean exitsts(String id);

    Image getById(String id);

    List<Image> getByProduct(String productId);

    Image formatImage(Image image);

    Image saveWithIdProduct(String id);





}
