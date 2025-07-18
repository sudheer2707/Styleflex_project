package com.sudheer.Styleflex.ProductRepo;

import com.sudheer.Styleflex.Model.Category;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

 Optional<Category> findByNameIgnoreCase(String name);    
}
