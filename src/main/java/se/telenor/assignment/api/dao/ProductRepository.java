package se.telenor.assignment.api.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import se.telenor.assignment.api.model.Product;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.type = ?1")
    List<Product> findByType(String param);
}
