package se.telenor.assignment.api.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.telenor.assignment.api.model.Product;
import se.telenor.assignment.api.repository.ProductRepository;

import java.util.List;

@Service
public class ProductRepositoryImpl{

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    public List<Product> getAllProducts(Product product) {
        return null;
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getProducts(String type) {
        return productRepository.findByType(type);
    }


}
