package se.telenor.assignment.api.model;

import lombok.Data;

//Query Parameter
@Data
public class ProductModel {
    private String type;
    private Double min_price;
    private Double max_price;
    private String city;
    private String property;
    private String color;
    private Double gb_limit_min;
    private Double gb_limit_max;
}
