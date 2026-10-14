package com.example.orderservice.controller;

import com.example.orderservice.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/getProduct/{id}")
    public ResponseEntity<Object> getProduct(@PathVariable Long id) {
        Object productData = orderService.getProductFromProductService(id);
        return ResponseEntity.ok(productData);
    }
}