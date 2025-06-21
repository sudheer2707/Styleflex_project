package com.sudheer.Styleflex.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private long id;
     @Column(nullable = true)
    private String name;
     @Column(nullable = true)
    private String description;
     @Column(nullable = true)
    private double price;
     @Column(nullable = true)
    private String category;
     @Column(nullable = true)
    private String imageUrl;

    public Products(){

    }
     public  Products(String name, String description, double price, String category, String imageUrl) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.imageUrl = imageUrl;
    }
    public long getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public double getPrice(){
        return price;
    }
    public String getCategory(){
        return category;
    }
    public String getImageUrl(){
        return imageUrl;
    }
    public void setId(long id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public void setCategory(String category){
       this.category = category;
    }
    public void setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
    }
}
