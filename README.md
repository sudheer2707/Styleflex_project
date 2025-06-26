# Styleflex_project
# 🛍️ Styleflex E-Commerce Backend

A Spring Boot-based e-commerce backend application for managing products with features like category filtering, keyword search, and image URL support.

---

## 🚀 Features

- Add, update, delete, and view products
- Assign categories to products
- Filter products by category
- Search products by name (case-insensitive)
- Supports image URLs for each product
- RESTful API structure
- Integrated with MySQL database

---

## 🛠️ Tech Stack

- **Backend:** Java, Spring Boot
- **Database:** MySQL
- **ORM:** Spring Data JPA (Hibernate)
- **Build Tool:** Maven
- **Tools:** Postman (for API testing), GitHub

---

## 🧾 API Endpoints

> Base URL: `http://localhost:8080/Products`

| Method | Endpoint                         | Description                       |
|--------|----------------------------------|-----------------------------------|
| POST   | `/add`                           | Add a new product                 |
| GET    | `/`                              | Get all products                  |
| GET    | `/{id}`                          | Get product by ID                 |
| PUT    | `/update/{id}`                   | Update product details            |
| DELETE | `/delete/{id}`                   | Delete product by ID              |
| GET    | `/search?name={keyword}`         | Search products by name           |
| GET    | `/filter/category/{name}`        | Filter products by category name  |

---

## 📁 Project Structure

com.sudheer.Styleflex
├── Model
│ ├── Products.java
│ ├── Category.java
│ ├── Order.java
│ └── OrderItem.java
├── Controller
│ └── ProductController.java
├── ProductRepo
│ ├── ProductsRepository.java
│ └── CategoryRepository.java
├── config
│ └── Config.java
└── Application.java
