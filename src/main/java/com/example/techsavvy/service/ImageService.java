package com.example.techsavvy.service;


import com.example.techsavvy.entity.Image;

import java.util.List;

public interface ImageService {
    Image addImage(Image image);

    Image getOneImage(Image image);

    Image getById(int id);

    List<Image> getListImage(List<Image> images);

    List<Image> saveLisImage(List<Image> images);
}
