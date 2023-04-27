package com.example.techsavvy.controller;

import com.example.techsavvy.entity.Image;
import com.example.techsavvy.entity.Product;
import com.example.techsavvy.service.CloudinaryService;
import com.example.techsavvy.service.ImageService;
import com.example.techsavvy.until.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/images")
@CrossOrigin
public class ImageController {
    @Autowired
    CloudinaryService cloudinaryService;
    @Autowired
    ImageService imageService;

    @PostMapping("/upload/{productId}")
    public ResponseEntity<Image> upload(@PathVariable String productId, @RequestBody MultipartFile multipartFile) throws IOException {
        BufferedImage bi = ImageIO.read(multipartFile.getInputStream());
        if (bi == null) {
            return new ResponseEntity(new Message("Lỗi upload image !!"), HttpStatus.BAD_REQUEST);
        }
        Map result = cloudinaryService.upload(multipartFile);
        Image image = new Image();
        Product product = new Product();
        product.setId(productId);
        image.setName((String) result.get("original_filename"));
        image.setImageUrl((String) result.get("url"));
        image.setId((String) result.get("public_id"));
        image.setProduct(product); // set the product ID
        return ResponseEntity.ok().body(imageService.addImage(image));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id) throws IOException {
        if (!imageService.exitsts(id)) {
            return new ResponseEntity<>(new Message("Ảnh không tồn tại"), HttpStatus.NOT_FOUND);
        }
        Optional<Image> image = imageService.getOne(id).get();
        Map result = cloudinaryService.delete(image.get().getId());
        imageService.delete(id);
        return new ResponseEntity<>(new Message("Đã xóa !!"), HttpStatus.OK);
    }

    @GetMapping("/getImageByProduct/{productId}")
    public ResponseEntity<List<Image>> getByProduct(@PathVariable("productId") String productId) {
        return ResponseEntity.ok().body(imageService.getByProduct(productId));
    }
}
