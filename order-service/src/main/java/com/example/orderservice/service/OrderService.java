package com.example.orderservice.service;

import com.example.orderservice.exception.ServiceUnavailableException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    private final RestTemplate restTemplate;

    public OrderService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Object getProductFromProductService(Long productId) {
        // RestTemplate được gắn @LoadBalanced sẽ tự động cân bằng tải Round-Robin
        String url = "http://PRODUCTSERVICE/api/v1/products/" + productId;

        try {
            return restTemplate.getForObject(url, Object.class);
        } catch (Exception e) {
            throw new ServiceUnavailableException("Service Unavailable");
        }
    }
}