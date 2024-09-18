package com.foodpanda.food_service.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.foodpanda.food_service.model.Food;

@Repository
public class FoodDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Food findByName(String name) {
        String sql = "SELECT * FROM food WHERE name = ?";
        try {
            return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
                Food food = new Food();
                food.setId(rs.getLong("id"));
                food.setName(rs.getString("name"));
                food.setPrice(rs.getBigDecimal("price"));
                return food;
            }, name);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public Food findById(Long id) {
        String sql = "SELECT * FROM food WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
                Food food = new Food();
                food.setId(rs.getLong("id"));
                food.setName(rs.getString("name"));
                food.setPrice(rs.getBigDecimal("price"));
                return food;
            }, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }


    public List<Food> getAllFood() {
        String sql = "SELECT * FROM food";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Food food = new Food();
            food.setId(rs.getLong("id"));
            food.setName(rs.getString("name"));
            food.setPrice(rs.getBigDecimal("price"));
            return food;
            });
    }

}
