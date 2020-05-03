package se.telenor.assignment.api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.telenor.assignment.api.model.Product;
import se.telenor.assignment.api.model.ProductModel;
import se.telenor.assignment.api.service.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductRestController {

  @Autowired
  private ProductService productService;

  @GetMapping()
  public ResponseEntity<List<Product>> getAllProducts(@ModelAttribute("productRequestModel") Optional<ProductModel> productRequestModel) {
    System.out.println("productRequestModel: " + productRequestModel.get());
    List<Product> productList;
    if (productRequestModel.isPresent()) {
      ProductModel productModel = productRequestModel.get();
      System.out.println("Going to get all product");
      productList = productService.getProducts(productModel.getType());
      System.out.println("productList size :: " + productList.size());
      productList.stream().forEach(product -> System.out.println(product.toString()));
    } else {
      productList = productService.getAllProducts();
    }
    return new ResponseEntity<>(productList, HttpStatus.OK);
  }
}
