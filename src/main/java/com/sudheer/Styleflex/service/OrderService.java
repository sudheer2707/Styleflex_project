package com.sudheer.Styleflex.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudheer.Styleflex.Model.Cart;
import com.sudheer.Styleflex.Model.Order;
import com.sudheer.Styleflex.Model.OrderItem;
import com.sudheer.Styleflex.Model.User;
import com.sudheer.Styleflex.ProductRepo.CartRepository;
import com.sudheer.Styleflex.ProductRepo.OrderItemRepository;
import com.sudheer.Styleflex.ProductRepo.OrderRepository;
import com.sudheer.Styleflex.ProductRepo.UserRepository;

@Service
public class OrderService {

     @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;
 
    @SuppressWarnings("static-access")
    public Order placeOrder(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        List<Cart> cartItems = cartRepository.findByUser(user);
        if (cartItems.isEmpty()) {
            throw new RuntimeException("Cart is empty");
        }

        Order order = new Order();
        order.setUser(user);
        order.setOrderDate(LocalDateTime.now());

        double totalAmount = 0;
        order = orderRepository.save(order); // Save first to generate order ID

        for (Cart cart : cartItems) {
            OrderItem item = new OrderItem();
            item.setOrder(order);
            item.setProduct(cart.getProduct());
            item.setQuantity(cart.getQuantity());
            double price = cart.getProduct().getPrice() * cart.getQuantity();
            item.setPrice(price);
            totalAmount += price;

            orderItemRepository.save(item);
        }

        order.setTotalAmount(totalAmount);
        orderRepository.save(order);

        cartRepository.deleteAll(cartItems); // Clear cart after order

        return order;
    }

    public List<Order> getUserOrders(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return orderRepository.findByUser(user);
    }
}
