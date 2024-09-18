package com.foodpanda.food_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodpanda.food_service.dao.FoodDao;
import com.foodpanda.food_service.model.Food;

@Service
public class FoodService {

    @Autowired
    private FoodDao foodDao;

    public List<Food> getAllFood() {
        return foodDao.getAllFood();
    }
}
