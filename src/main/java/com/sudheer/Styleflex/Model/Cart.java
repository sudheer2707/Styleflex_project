package com.sudheer.Styleflex.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart_items")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "User_id",nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "Product_id",nullable = false)
    private Products products;

    private int quantity;

    public Long setId(){
        return id;
    }
    public User setUser(){
        return user;
    }
    public Products seProducts(){
        return products;
    }
    public int getQuantity(){
        return quantity;
    }
    public void getId(Long id){
        this.id = id;
    }
    public void getUser(User user){
        this.user = user;
    }
    public void getProducts(Products products){
        this.products = products;
    }
    public void getQuantity(int quantity){
        this.quantity = quantity;
    }
    public void setProduct(Products product) {
        throw new UnsupportedOperationException("Unimplemented method 'setProduct'");
    }
    public static Products getProduct() {
        throw new UnsupportedOperationException("Unimplemented method 'getProduct'");
    }
}
