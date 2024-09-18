package com.foodpanda.order_service.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.foodpanda.order_service.model.Order;

// import java.math.BigDecimal;
// import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Method to insert a new order
    public int saveOrder(Order order) {
        String sql = "INSERT INTO orders (food_id, order_date, quantity, total_price, user_id) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, 
            order.getFoodId(), 
            order.getOrderDate(), 
            order.getQuantity(), 
            order.getTotalPrice(), 
            order.getUserId());
    }

    // Method to find an order by its ID
    public Optional<Order> findById(Long id) {
        String sql = "SELECT * FROM orders WHERE id = ?";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Order order = new Order();
            order.setId(rs.getLong("id"));
            order.setFoodId(rs.getLong("food_id"));
            order.setOrderDate(rs.getTimestamp("order_date"));
            order.setQuantity(rs.getInt("quantity"));
            order.setTotalPrice(rs.getBigDecimal("total_price"));
            order.setUserId(rs.getLong("user_id"));
            return order;
        }, id).stream().findFirst();
    }

    // Method to get all orders
    public List<Order> getAllOrders() {
        String sql = "SELECT * FROM orders";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Order order = new Order();
            order.setId(rs.getLong("id"));
            order.setFoodId(rs.getLong("food_id"));
            order.setOrderDate(rs.getTimestamp("order_date"));
            order.setQuantity(rs.getInt("quantity"));
            order.setTotalPrice(rs.getBigDecimal("total_price"));
            order.setUserId(rs.getLong("user_id"));
            return order;
        });
    }
}
