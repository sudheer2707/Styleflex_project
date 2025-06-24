package com.sudheer.Styleflex.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY )
private Long id;
@Column(nullable = false)
private String name;

@Column(unique = true)
private String email;
@Column(nullable = false)
private String password;

public User(){
}
public User(String name,String email,String password){
    this.name = name;
    this.email = email;
    this.password = password;
}
public long getId(){
    return id;
}
public String getName(){
    return name;
}
public String getEmail(){
    return email;
}
public String getPassword(){
    return password;
}
public void setId(long id){
    this.id = id;
}
public void setName(String name){
    this.name = name;
}
public void setEmail(String email){
    this.email = email;
}
public void setPassword(String password){
    this.password = password;
}
}
