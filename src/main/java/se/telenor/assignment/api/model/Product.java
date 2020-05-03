package se.telenor.assignment.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String color;
    private String gbLimit;
    private Double price;
    private String address;
    private String city;

    public void setType(String type) {
        this.type = type;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @JsonProperty(value = "properties")
    public void setGbLimit(String gbLimit) {
        this.gbLimit = gbLimit;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    @JsonProperty(value = "properties")
    public String getGbLimit() {
        return gbLimit;
    }

    public Double getPrice() {
        return price;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", color='" + color + '\'' +
                ", gbLimit=" + gbLimit +
                ", price=" + price +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
