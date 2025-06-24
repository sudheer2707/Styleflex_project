package com.sudheer.Styleflex.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sudheer.Styleflex.Model.Cart;
import com.sudheer.Styleflex.service.CartService;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins ="*")
public class CartController {

    @Autowired
    private CartService cartService;

     @PostMapping("/add")
    public Cart addToCart(@RequestParam Long userId, @RequestParam Long productId, @RequestParam int quantity) {
        return cartService.addToCart(userId, productId, quantity);
    }

    @GetMapping("/{userId}")
    public List<Cart> getCartItems(@PathVariable Long userId) {
        return cartService.getCartByUser(userId);
    }
    @DeleteMapping("/remove/{cartItemId}")
    public String removeItem(@PathVariable Long cartItemId) {
        cartService.removeFromCart(cartItemId);
        return "Item removed from cart.";
    }

}
