package com.foodpanda.order_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodpanda.order_service.Client.FoodClient;
import com.foodpanda.order_service.Client.UserClient;
import com.foodpanda.order_service.dao.OrderDao;
import com.foodpanda.order_service.dto.Food;
import com.foodpanda.order_service.dto.User;
import com.foodpanda.order_service.model.Order;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;

@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private UserClient userClient;

    @Autowired
    private FoodClient foodClient;

    // Method to create an order
    public Order createOrder(Long userId, Long foodId, int quantity) {
        // Fetch user details from the UserService
        User user = userClient.getUserById(userId);
        if (user == null) {
            throw new RuntimeException("User not found");
        }

        // Fetch food details from the FoodService
        Food food = foodClient.getFoodById(foodId);
        if (food == null) {
            throw new RuntimeException("Food not found");
        }

        // Calculate total price
        BigDecimal totalPrice = food.getPrice().multiply(new BigDecimal(quantity));

        // Create a new order
        Order order = new Order();
        order.setUserId(userId);
        order.setFoodId(foodId);
        order.setQuantity(quantity);
        order.setTotalPrice(totalPrice);
        order.setOrderDate(Timestamp.from(Instant.now()));

        // Save the order in the database
        orderDao.saveOrder(order);

        return order;
    }

    // Method to retrieve an order by ID
    public Order getOrderById(Long id) {
        return orderDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }
}
