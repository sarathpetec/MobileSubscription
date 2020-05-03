package se.telenor.assignment.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.telenor.assignment.api.model.Product;
import se.telenor.assignment.api.repository.ProductRepository;

@Component
public class DataLoadService {

    @Autowired
    private ProductRepository productRepository;

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
