package se.telenor.assignment.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.telenor.assignment.api.Controller.DataLoadRestController;
import se.telenor.assignment.api.model.Product;
import se.telenor.assignment.api.repository.ProductRepository;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class DataLoadService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> loadCSVToDB() throws Exception{
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
            product.setType(getProductType(lineArray));
            product.setColor(getProductPropertiesColor(lineArray));
            product.setGbLimit(getProductPropertiesGbLimit(lineArray));
            product.setPrice(getPrice(lineArray));
            product.setAddress(getStoreAddress(lineArray));
            product.setCity(getStoreCity(lineArray));

            System.out.println("product : "+product);
            Product product1 = saveProduct(product);
            productList.add(product1);
        }
        return productList;
    }

    public String getProductType(String[] lineArray) {
        String value = lineArray[0];
        return value;
    }

    public String getProductPropertiesColor(String[] lineArray) {
        String value = lineArray[1];
        if (value.contains("color"))
            return value.split(":")[1];
        return "";
    }

    public double getProductPropertiesGbLimit(String[] lineArray) {
        String value = lineArray[1];
        if (value.contains("gb_limit"))
            return Double.parseDouble(value.split(":")[1]);
        return 0;
    }

    public double getPrice(String[] lineArray) {
        String value = lineArray[2];
        return Double.parseDouble(value);
    }

    public String getStoreAddress(String[] lineArray) {
        String value = lineArray[3];
        return value.replace("\"", "");
    }

    public String getStoreCity(String[] lineArray) {
        String value = lineArray[4];
        value = value.replace("\"", "");
        return  value.replace(" ", "");
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
}
