package com.example.techsavvy.controller;

import com.example.techsavvy.entity.Image;
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

    @PostMapping("/upload")
    public ResponseEntity<Image> upload(@RequestBody MultipartFile multipartFile)throws IOException {
        BufferedImage bi = ImageIO.read(multipartFile.getInputStream());
        if(bi == null){
            return new ResponseEntity(new Message("Lỗi upload image !!"), HttpStatus.BAD_REQUEST);
        }
        Map result = cloudinaryService.upload(multipartFile);
        Image image = new Image();
        image.setName((String) result.get("original_filename") );
        image.setImageUrl((String) result.get("url"));
        image.setId((String) result.get("public_id"));
        return  ResponseEntity.ok().body(imageService.addImage(image));
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id) throws IOException {
        if( !imageService.exitsts(id)){
            return new ResponseEntity(new Message("no existe"), HttpStatus.NOT_FOUND);
        }
        Optional<Image> image = imageService.getOne(id).get();
        Map result = cloudinaryService.delete(image.get().getId());
        imageService.delete(id);
        return new ResponseEntity(new Message("Đã xóa !!"), HttpStatus.OK);
    }

}
