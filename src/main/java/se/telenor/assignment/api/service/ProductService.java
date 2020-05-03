package se.telenor.assignment.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.telenor.assignment.api.model.Product;
import se.telenor.assignment.api.repository.ProductRepository;

import java.util.List;

@Component
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    public List<Product> getAllProducts(Product product) {
        return null;
    }

    public List<Product> getProducts(String type) {
        return productRepository.findByType(type);
    }


}
