package com.example.techsavvy.serviceIpml;

import com.example.techsavvy.entity.Image;
import com.example.techsavvy.repository.ImageRepository;
import com.example.techsavvy.service.ImageService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class ImageImpl implements ImageService {

    private final ImageRepository imageRepository;

    @Override
    public Image addImage(Image image) {
        return imageRepository.save(image);
    }

    @Override
    public Image getOneImage(Image image) {
        Image image1 = new Image();
        image1.setId(image.getId());
        image1.setUrl(image.getUrl());
        image1.setHienThi(image.isHienThi());
        return image1;
    }

    @Override
    public Image getById(int id) {
        return imageRepository.findById(id);
    }


    @Override
    public List<Image> getListImage(List<Image> images) {
        List<Image> imageList = new ArrayList<>();
        for (Image image1 : images) {
            imageList.add(getById(image1.getId()));
        }
        return imageList;
    }

    @Override
    public List<Image> saveLisImage(List<Image> images) {
        List<Image> imageList = new ArrayList<>();
        for (Image image : images) {
            Image savedImage = imageRepository.save(image);
            imageList.add(savedImage);
        }
        return imageList;
    }
}
