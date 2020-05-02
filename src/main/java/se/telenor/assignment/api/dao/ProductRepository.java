package se.telenor.assignment.api.dao;

import org.springframework.data.repository.CrudRepository;
import se.telenor.assignment.api.model.Product;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findByType(String param);
}
