package com.sudheer.Styleflex.Model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)  
  private Long id;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDateTime orderDate;

    private double totalAmount;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Order> items;

    public Order() {}

     public Order(User user, LocalDateTime orderDate, double totalAmount) {
        this.user = user;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
    }
    public long getId(){
        return id;
    } 
     public User getUser(){
        return user;
    } 
     public LocalDateTime getOrderDate(){
        return orderDate;
    } 
    public double getTotalAmount(){
        return totalAmount;
    }
    public List<Order> getItems() {
        return items;
    }
    public void setId(long id){
    this.id = id;
   }
   public void setUser(User user){
    this.user = user;
   }
   public void setOrderDate(LocalDateTime orderDate){
    this.orderDate = orderDate;
   }
   public void setTotalAmount(double totalAmount){
    this.totalAmount = totalAmount;
   }
   public void setItems(List<Order> items){
    this.items = items;
   }
}


