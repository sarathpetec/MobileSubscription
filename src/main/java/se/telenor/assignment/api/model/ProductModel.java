package se.telenor.assignment.api.model;

import lombok.Data;

@Data
public class ProductModel {
    private String type;
    private Double min_price;
    private Double max_price;
    private String city;
    private String address;
    private String color;
    private Double gb_limit_min;
    private Double gb_limit_max;


    public Double getMin_price() {
        return min_price;
    }

    public void setMin_price(Double min_price) {
        this.min_price = min_price;
    }

    public Double getMax_price() {
        return max_price;
    }

    public void setMax_price(Double max_price) {
        this.max_price = max_price;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getGb_limit_min() {
        return gb_limit_min;
    }

    public void setGb_limit_min(Double gb_limit_min) {
        this.gb_limit_min = gb_limit_min;
    }

    public Double getGb_limit_max() {
        return gb_limit_max;
    }

    public void setGb_limit_max(Double gb_limit_max) {
        this.gb_limit_max = gb_limit_max;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
