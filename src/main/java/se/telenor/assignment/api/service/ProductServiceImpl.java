package se.telenor.assignment.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.telenor.assignment.api.dao.ProductRepository;
import se.telenor.assignment.api.model.Product;
import se.telenor.assignment.api.model.ProductModel;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public List<Product> getAllProducts(Product product) {
        return null;
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getProducts(String type) {
        return productRepository.findByType(type);
    }


}
