package com.sudheer.Styleflex.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sudheer.Styleflex.Model.Order;
import com.sudheer.Styleflex.service.OrderService;

@RestController
@RequestMapping("/orders")  // RESTful base path
@CrossOrigin(origins = "*") // Allow frontend (JS) to access these APIs
public class OrderController {

    @Autowired
    private OrderService orderService;

    // Place a new order for a user
    @PostMapping("/place/{userId}")
    public Order placeOrder(@PathVariable Long userId) {
        return orderService.placeOrder(userId);
    }

    // Get all orders for a user
    @GetMapping("/user/{userId}")
    public List<Order> getUserOrders(@PathVariable Long userId) {
        return orderService.getUserOrders(userId);
    }
}
