package com.sudheer.Styleflex.ProductRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sudheer.Styleflex.Model.Products;

@Repository
public interface ProductsRepository extends JpaRepository <Products,Long>{
    List<Products>findByNameContainingIgnoreCase(String name);

    List<Products>findByCategory(com.sudheer.Styleflex.Model.Category category);

}
