package com.example.techsavvy.serviceIpml;

import com.example.techsavvy.entity.Product;
import com.example.techsavvy.entity.Type;
import com.example.techsavvy.repository.ProductRepository;
import com.example.techsavvy.service.ProductService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

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
    public Product getProductById(String id) {

        return productRepository.findProductById(id);
    }


    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(String id) {
        Product product = getProductById(id);
        product.setStatus(false);
        productRepository.save(product);

    }

    @Override
    public Type getProductsByType(int id) {
        return null;
    }


    @Override
    public String generateLoHang() {
        Random random = new Random();
        String loHang = "";
        boolean check = false;
        int attempts = 0;
        int maxAttempts = 10000; // set a maximum number of attempts to prevent infinite loop
        while (!check && attempts < maxAttempts) {
            int number = random.nextInt(10000);
            loHang = "LHS" + String.format("%04d", number);
            if (productRepository.findProductByLo(loHang) == null) {
                check = true;
            }
            attempts++;
        }
        if (!check) {
            throw new RuntimeException("Unable to generate a unique ID after " + maxAttempts + " attempts.");
        }
        return loHang;
    }

    @Override
    public String generateIdProduct() {
        Random random = new Random();
        String newId = "";
        boolean isUnique = false;
        while (!isUnique) {
            int number = random.nextInt(10000);
            newId = "SP" + String.format("%04d", number);
            List<Product> products = productRepository.findAll();
            if (products.isEmpty()) {
                isUnique = true;
            } else {
                String finalNewId = newId;
                boolean isDuplicate = products.stream().anyMatch(p -> p.getId().equals(finalNewId));
                if (!isDuplicate) {
                    isUnique = true;
                }
            }
        }
        return newId;
    }

}
