package com.example.techsavvy.serviceIpml;

import com.example.techsavvy.entity.Image;
import com.example.techsavvy.repository.ImageRepository;
import com.example.techsavvy.service.ImageService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public void delete(String id) {
        imageRepository.deleteById(id);
    }

    @Override
    public Optional<Optional<Image>> getOne(String id) {
        return Optional.of(imageRepository.findById(id));
    }

    @Override
    public boolean exitsts(String id) {
        return imageRepository.existsById(id);
    }


    @Override
    public Image getById(String id) {
        return imageRepository.findImageById(id);
    }




}
