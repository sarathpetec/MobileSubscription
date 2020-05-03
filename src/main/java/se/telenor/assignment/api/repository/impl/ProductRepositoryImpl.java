package se.telenor.assignment.api.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import se.telenor.assignment.api.model.Product;
import se.telenor.assignment.api.model.ProductModel;
import se.telenor.assignment.api.repository.ProductRepository;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;


@Service
public class ProductRepositoryImpl{

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> findByCriteria(ProductModel productModel){
        return productRepository.findAll((Specification<Product>) (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if(productModel.getType()!=null) {
                predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("type"), productModel.getType())));
            }
            if(productModel.getColor()!=null) {
                predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("color"), productModel.getColor())));
            }
            if(productModel.getCity()!=null) {
                predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("city"), productModel.getCity())));
            }
            if(productModel.getAddress()!=null) {
                predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("address"), productModel.getAddress())));
            }
            if(productModel.getMin_price()!=null) {
                predicates.add(criteriaBuilder.and(criteriaBuilder.le(root.get("price"), productModel.getMin_price())));
            }
            if(productModel.getMax_price()!=null) {
                predicates.add(criteriaBuilder.and(criteriaBuilder.ge(root.get("price"), productModel.getMax_price())));
            }
            if(productModel.getGb_limit_min()!=null) {
                predicates.add(criteriaBuilder.and(criteriaBuilder.le(root.get("gbLimit"), productModel.getGb_limit_min())));
            }
            if(productModel.getGb_limit_max()!=null) {
                predicates.add(criteriaBuilder.and(criteriaBuilder.ge(root.get("gbLimit"), productModel.getGb_limit_max())));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        });
    }

}
