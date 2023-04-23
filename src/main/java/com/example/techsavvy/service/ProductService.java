package com.example.techsavvy.service;


import com.example.techsavvy.entity.Image;
import com.example.techsavvy.entity.Product;
import com.example.techsavvy.entity.Specification;
import com.example.techsavvy.entity.Type;
import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product getProductById(String id);

    Product saveProduct(Product product);

    void deleteProduct(String id);

    Type getProductsByType(int idType);

    Product getOneProduct(Product product);


    Product formatProduct(Product product);

    List<Product> getListProduct(List<Product> productList);
    String generateLoHang();
    String generateIdProduct();



}
