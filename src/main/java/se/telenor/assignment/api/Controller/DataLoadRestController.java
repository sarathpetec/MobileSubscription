package se.telenor.assignment.api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.telenor.assignment.api.model.Product;
import se.telenor.assignment.api.service.DataLoadService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/dataload")
public class DataLoadRestController {

  @Autowired
  private DataLoadService dataLoadService;

  @GetMapping()
  public ResponseEntity<List<Product>> loadCSVToDB() throws Exception {
    List<Product> productList = new ArrayList<>();
    BufferedReader subFileBufferedReader =
        new BufferedReader(
            new InputStreamReader(DataLoadRestController.class.getResourceAsStream("/data.csv")));
    String[] subFileColumnNames = subFileBufferedReader.readLine().split(",");
    System.out.println("subFileColumnNames: " + subFileColumnNames.length);
    Arrays.stream(subFileColumnNames).forEach(s -> System.out.println("Value :: " + s));

    String[] key;
    String line;
    while (Objects.nonNull((line = subFileBufferedReader.readLine()))) {
      String[] lineArray = line.split(",", -1);
      Product product = new Product();
      product.setType(dataLoadService.getProductType(lineArray));
      product.setColor(dataLoadService.getProductPropertiesColor(lineArray));
      product.setGbLimit(dataLoadService.getProductPropertiesGbLimit(lineArray));
      product.setPrice(dataLoadService.getPrice(lineArray));
      product.setAddress(dataLoadService.getStoreAddress(lineArray));
      product.setCity(dataLoadService.getStoreCity(lineArray));

      System.out.println("product : "+product);
      Product product1 = dataLoadService.saveProduct(product);
      productList.add(product1);
    }
    return new ResponseEntity<>(productList, HttpStatus.OK);
  }


}
