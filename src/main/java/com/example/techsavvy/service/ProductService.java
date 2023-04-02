package com.example.techsavvy.service;


import com.example.techsavvy.entity.Product;
import com.example.techsavvy.entity.Type;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product getProductById(int id);

    void saveProduct(Product product);

    void deleteProduct(int id);

    List<Product> getProductsByType(Type type);


    List<Product> getBestSellingProducts();

    List<Product> getPopularProducts();

    List<Product> getLatestProducts();

    Product getOneProduct(Product product);

    List<Product> getListProduct(List<Product> productList);

}
