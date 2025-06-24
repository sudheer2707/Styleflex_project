package com.sudheer.Styleflex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudheer.Styleflex.Model.Cart;
import com.sudheer.Styleflex.Model.Products;
import com.sudheer.Styleflex.Model.User;
import com.sudheer.Styleflex.ProductRepo.CartRepository;
import com.sudheer.Styleflex.ProductRepo.ProductsRepository;
import com.sudheer.Styleflex.ProductRepo.UserRepository;
@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductsRepository productsRepository;



    public Cart addToCart(Long userId, Long productId, int quantity) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Products product = productsRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));

        Cart cart = new Cart();
        cart.getUser(user);
        cart.setProduct(product);
        cart.getQuantity(quantity);

        return cartRepository.save(cart);
}
 public List<Cart> getCartByUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return cartRepository.findByUser(user);
    }

    public void removeFromCart(Long cartItemId) {
        cartRepository.deleteById(cartItemId);
    }
}

