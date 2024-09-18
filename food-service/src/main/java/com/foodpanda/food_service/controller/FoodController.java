package com.foodpanda.food_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodpanda.food_service.dao.FoodDao;
import com.foodpanda.food_service.model.Food;



@RestController
@RequestMapping("/api/food")
public class FoodController {

    @Autowired
    private FoodDao foodDao;

    @GetMapping
    public List<Food> getAllFood() {
        return foodDao.getAllFood();
    }

    @GetMapping("/{id}")
    public Food getFoodById(@PathVariable("id") Long id) {
        return foodDao.findById(id);
    }
}
