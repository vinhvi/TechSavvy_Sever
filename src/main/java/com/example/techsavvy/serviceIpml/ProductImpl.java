package com.example.techsavvy.serviceIpml;

import com.example.techsavvy.entity.Image;
import com.example.techsavvy.entity.Product;
import com.example.techsavvy.entity.Specification;
import com.example.techsavvy.entity.Type;
import com.example.techsavvy.repository.ProductRepository;
import com.example.techsavvy.repository.SpecificationRepository;
import com.example.techsavvy.service.ImageService;
import com.example.techsavvy.service.ProductService;
import com.example.techsavvy.service.SpecificationService;
import com.example.techsavvy.service.TypeService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class ProductImpl implements ProductService {
    private final ProductRepository productRepository;


    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(int id) {

        return productRepository.findProductById(id);
    }


    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(int id) {
        Product product = getProductById(id);
        product.setStatus(false);
        productRepository.save(product);

    }

    @Override
    public Type getProductsByType(int id) {
        return null;
    }

    @Override
    public Product getOneProduct(Product product) {
        Product product1 = formatProduct(product);
        return product1;
    }

    @Override
    public Product formatProduct(Product product) {
        Product product1 = new Product();
        product1.setId(product.getId());
        product1.setName(product.getName());
        product1.setCounts(product.getCounts());
        product1.setLo(product.getLo());
        product1.setStatus(product.isStatus());
        product1.setOrigin(product.getOrigin());
        return product1;
    }

    @Override
    public List<Product> getListProduct(List<Product> productList) {
        return null;
    }

}
