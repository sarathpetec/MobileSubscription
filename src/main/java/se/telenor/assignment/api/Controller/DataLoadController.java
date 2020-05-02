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
   Arrays.stream(subFileColumnNames).forEach(s -> System.out.println("Value :: "+s));

      String[] key;
      String line;
      while (Objects.nonNull((line = subFileBufferedReader.readLine()))) {
          key = new String[5];
          String[] lineArray = line.split(",", -1);
          for(int i=0;i<5;i++){
              System.out.println(lineArray[i]);
          }
      System.out.println("-------------");
      }

  }
}
