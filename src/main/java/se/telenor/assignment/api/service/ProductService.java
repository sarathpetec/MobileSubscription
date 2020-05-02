package se.telenor.assignment.api.service;

import se.telenor.assignment.api.model.Product;
import se.telenor.assignment.api.model.ProductModel;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    List<Product> getAllProducts(ProductModel request);

    Product saveProduct(Product product);
}
