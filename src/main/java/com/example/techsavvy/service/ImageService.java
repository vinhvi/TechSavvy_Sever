package com.example.techsavvy.service;


import com.example.techsavvy.entity.Image;

import java.util.Optional;

public interface ImageService {
    Image addImage(Image image);

    void delete(String id);

    Optional<Optional<Image>> getOne(String id);

    boolean exitsts(String id);

    Image getById(String id);

}
