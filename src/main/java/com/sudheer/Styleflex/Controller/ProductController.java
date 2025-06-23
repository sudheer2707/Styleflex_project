package com.sudheer.Styleflex.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sudheer.Styleflex.Model.Products;
import com.sudheer.Styleflex.ProductRepo.CategoryRepository;
import com.sudheer.Styleflex.ProductRepo.ProductsRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/Products")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductsRepository productsRepository;

    @SuppressWarnings("unused")
    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping("/add")
    public Products addProduct(@RequestBody Products products){
        return productsRepository.save(products);
    }
    @GetMapping
    public List<Products> getAllProducts(){
        return productsRepository.findAll();
    }
    @GetMapping("/{id}")
    public Products getProductById(@PathVariable Long id){
        Optional<Products> products = productsRepository.findById(id);
        return products.orElse(null);
    }
    @PutMapping("/update/{id}")
    public Products updateProducts(@PathVariable Long id, @RequestBody Products updateProducts){
        return productsRepository.findById(id).map(products -> {
             products.setName(updateProducts.getName());
           products.setDescription(updateProducts.getDescription());
            products.setPrice(updateProducts.getPrice());
            products.setImageUrl(updateProducts.getImageUrl());
            products.setCategory(updateProducts.getCategory());
            return productsRepository.save(products);
        }).orElse(null); 
        
    }
      @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        if (productsRepository.existsById(id)) {
            productsRepository.deleteById(id);
            return "Product deleted successfully.";
        } else {
            return "Product not found.";
        }
}
}
    
    

