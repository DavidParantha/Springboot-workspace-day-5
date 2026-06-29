package com.productclient.prodclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProductClientController {

    @Autowired
    private RestTemplate restTemplate;

    // This endpoint is in the CLIENT - it calls the ProductService (on port 8081)
    // Access this at: http://localhost:8080/fetch-product
    @GetMapping("/fetch-product")
    public String getProduct() {
        // Async-style: RestTemplate makes a synchronous HTTP call to ProductService
        String response = restTemplate.getForObject("http://localhost:8080/product", String.class);
        return "Response from ProductService: " + response;
    }
}