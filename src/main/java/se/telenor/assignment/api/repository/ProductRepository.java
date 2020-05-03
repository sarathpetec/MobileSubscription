package se.telenor.assignment.api.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import se.telenor.assignment.api.model.Product;

import java.util.List;


public interface ProductRepository extends CrudRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    @Query("SELECT p FROM Product p WHERE p.type = ?1")
    List<Product> findByType(String typr);

    @Query("SELECT p FROM Product p WHERE p.color = ?1")
    List<Product> findByColor(String color);

    @Query("SELECT p FROM Product p WHERE p.type = ?1")
    List<Product> findByGbLimit(String gbLimit);

    @Query("SELECT p FROM Product p WHERE p.price = ?1")
    List<Product> findByPrice(String price);

    @Query("SELECT p FROM Product p WHERE p.address = ?1")
    List<Product> findByAddress(String address);

    @Query("SELECT p FROM Product p WHERE p.city = ?1")
    List<Product> findByCity(String city);

}
