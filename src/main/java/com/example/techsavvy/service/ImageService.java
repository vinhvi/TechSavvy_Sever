package com.example.techsavvy.service;


import com.example.techsavvy.entity.Image;

public interface ImageService {
    Image addImage(Image image);

    Image getOneImage(Image image);
}
