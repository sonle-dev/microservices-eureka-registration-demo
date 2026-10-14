package com.example.productservice.controller;

import com.example.productservice.dto.ProductResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable Long id) {
        log.info("===> [PRODUCT-SERVICE] Serving request for productId: {} from PORT: {}", id, serverPort);

        ProductResponse response = new ProductResponse(
                id,
                "Iphone 17 (served by port " + serverPort + ")",
                new BigDecimal("123456.0"),
                50
        );
        return ResponseEntity.ok(response);
    }
}