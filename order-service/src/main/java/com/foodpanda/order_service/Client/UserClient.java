package com.foodpanda.order_service.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.foodpanda.order_service.dto.User;

@FeignClient(name="user-service")
public interface UserClient {

    @GetMapping("/auth/users/{id}")
    User getUserById(@PathVariable("id") Long id);
}
