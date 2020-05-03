package se.telenor.assignment.api.service;

import se.telenor.assignment.api.model.Product;
import se.telenor.assignment.api.model.ProductModel;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    List<Product> getAllProducts(Product product);

    Product saveProduct(Product product);

    public List<Product> getProducts(String type);
}
