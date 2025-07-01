package com.sudheer.Styleflex.Controller;

import java.util.Optional;
import java.util.List;
import com.sudheer.Styleflex.Model.Category;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sudheer.Styleflex.ProductRepo.CategoryRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping
    public Category addCategory(@RequestBody Category category){
        return categoryRepository.save(category);
    }
    @GetMapping
    public List<com.sudheer.Styleflex.Model.Category> getAllCategories(){
        return categoryRepository.findAll();
    }
    @GetMapping("/{id}")
    public com.sudheer.Styleflex.Model.Category getCategoryById(@PathVariable Long id){
        Optional<com.sudheer.Styleflex.Model.Category> category = categoryRepository.findById(id);
        return category.orElse(null);
    } 
  

    }
    


