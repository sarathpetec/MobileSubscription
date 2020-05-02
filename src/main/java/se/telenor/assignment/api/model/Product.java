package se.telenor.assignment.api.model;

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
    private Integer gbLimit;
    private Double price;
    private String address;

    public String getProperties(){
        if(type.equals("phone")){
            return "color:" + this.color;
        }
        //for subscription
        return "gb_limit:" + this.gbLimit;
    }

    public void setProperties(String properties){
        if(null != properties){
            if(properties.contains("color")){
                setColor(properties);
            }
            else{
                setGbLimit(properties);
            }
        }
    }
    public void setColor(String color) {
        if(null != color){
            if(color.contains(":")){
                try{
                    this.color = color.split(":")[1];
                }
                catch(ArrayIndexOutOfBoundsException e){
                }
            }
            else{
                this.color = color;
            }
        }
    }

    public void setGbLimit(String gbLimit){
        if(null != gbLimit){
            if(gbLimit.contains(":")){
                try{
                    this.gbLimit = Integer.parseInt(gbLimit.split(":")[1]);
                }
                catch(ArrayIndexOutOfBoundsException e){
                }
            }else{
                this.gbLimit = Integer.parseInt(gbLimit);
            }
        }
        else{
            this.gbLimit = 10; //default value
        }
    }

}
