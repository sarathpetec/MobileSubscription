package se.telenor.assignment.api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.telenor.assignment.api.model.Product;
import se.telenor.assignment.api.service.DataLoadService;

import java.util.List;

@RestController
@RequestMapping("/dataload")
public class DataLoadRestController {

  @Autowired
  private DataLoadService dataLoadService;

  @GetMapping()
  public ResponseEntity<List<Product>> loadCSVToDB() throws Exception {
    List<Product> productList = dataLoadService.loadCSVToDB();
    return new ResponseEntity<>(productList, HttpStatus.OK);
  }


}
