package com.sudheer.Styleflex.ProductRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sudheer.Styleflex.Model.Products;

@Repository
public interface ProductsRepository extends JpaRepository <Products,Long>{

}
