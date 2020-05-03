package se.telenor.assignment.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.telenor.assignment.api.model.Product;
import se.telenor.assignment.api.model.ProductModel;
import se.telenor.assignment.api.repository.impl.ProductRepositoryImpl;

import java.util.List;
import java.util.Objects;

@Component
public class ProductService {

    @Autowired
    private ProductRepositoryImpl productRepositoryImpl;

    public List<Product> getAllProducts(ProductModel productModel) {
        System.out.println("ProductModel: " + productModel);
        List<Product> productList;
        if (Objects.nonNull(productModel)) {
            productList = findByCriteria(productModel);
            System.out.println("productList size :: " + productList.size());
            productList.stream().forEach(product -> System.out.println(product.toString()));
        } else {
            productList = productRepositoryImpl.getAllProducts();
        }
        return productList;
    }

    public List<Product> findByCriteria(ProductModel productModel) {
        return productRepositoryImpl.findByCriteria(productModel);
    }



}
