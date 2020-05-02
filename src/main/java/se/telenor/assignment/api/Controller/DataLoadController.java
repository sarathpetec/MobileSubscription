package se.telenor.assignment.api.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.telenor.assignment.api.model.Product;
import se.telenor.assignment.api.model.ProductModel;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/dataload")
public class DataLoadController {

  @GetMapping()
  public void loadCSVToDB() throws Exception {
    BufferedReader subFileBufferedReader =
        new BufferedReader(
            new InputStreamReader(DataLoadController.class.getResourceAsStream("/data.csv")));
    String[] subFileColumnNames = subFileBufferedReader.readLine().split(",");
    System.out.println("subFileColumnNames: " + subFileColumnNames.length);
    Arrays.stream(subFileColumnNames).forEach(s -> System.out.println("Value :: " + s));

    String[] key;
    String line;
    while (Objects.nonNull((line = subFileBufferedReader.readLine()))) {
      String[] lineArray = line.split(",", -1);
      Product product = new Product();
      product.setType(getProductType(lineArray));
      product.setColor(getProductPropertiesColor(lineArray));
      product.setGbLimit(getProductPropertiesGbLimit(lineArray));
      product.setPrice(getPrice(lineArray));
      product.setAddress(getStoreAddress(lineArray));
      product.setCity(getStoreCity(lineArray));

      System.out.println("product : "+product);
    }
  }

  private String getProductType(String[] lineArray) {
    String value = lineArray[0];
    return value;
  }

  private String getProductPropertiesColor(String[] lineArray) {
    String value = lineArray[1];
    if (value.contains("color"))
      return value.split(":")[1];
    return "";
  }

  private double getProductPropertiesGbLimit(String[] lineArray) {
    String value = lineArray[1];
    if (value.contains("gb_limit"))
      return Double.parseDouble(value.split(":")[1]);
    return 0;
  }

  private double getPrice(String[] lineArray) {
    String value = lineArray[2];
    return Double.parseDouble(value);
  }

  private String getStoreAddress(String[] lineArray) {
    String value = lineArray[3];
    return value.replace("\"", "");
  }

  private String getStoreCity(String[] lineArray) {
    String value = lineArray[4];
    return value.replace("\"", "");
  }
}
