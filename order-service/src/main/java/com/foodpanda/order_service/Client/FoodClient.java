package com.foodpanda.order_service.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.foodpanda.order_service.dto.Food;

@FeignClient(name="food-service")
public interface FoodClient {

    @GetMapping("/api/food/{id}")
    Food getFoodById(@PathVariable("id") Long id);
}
