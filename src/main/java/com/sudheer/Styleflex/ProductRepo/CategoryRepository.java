package com.sudheer.Styleflex.ProductRepo;

import com.sudheer.Styleflex.Model.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    java.util.Locale.Category save(java.util.Locale.Category category);
    
}
