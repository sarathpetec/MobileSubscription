package se.telenor.assignment.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.telenor.assignment.api.model.Product;
import se.telenor.assignment.api.model.ProductModel;
import se.telenor.assignment.api.repository.impl.ProductRepositoryImpl;

import java.util.List;

@Component
public class ProductService {

    @Autowired
    private ProductRepositoryImpl productRepositoryImpl;

    public List<Product> getAllProducts() {
        return productRepositoryImpl.getAllProducts();
    }

    public List<Product> findByCriteria(ProductModel productModel) {
        return productRepositoryImpl.findByCriteria(productModel);
    }



}
