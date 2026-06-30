package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class BankConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/bank/getCartData")
    public String getCartData() {
        String response = restTemplate.getForObject("http://CART-SERVICE/cart/getData", String.class);
        return "Bank Service received from Cart: " + response;
    }

    @GetMapping("/bank/getPaymentData")
    public String getPaymentData() {
        String response = restTemplate.getForObject("http://PAYMENT-SERVICE/payment/getData", String.class);
        return "Bank Service received from Payment: " + response;
    }

    @GetMapping("/bank/getAllData")
    public String getAllData() {
        String cartResponse = restTemplate.getForObject("http://CART-SERVICE/cart/getData", String.class);
        String paymentResponse = restTemplate.getForObject("http://PAYMENT-SERVICE/payment/getData", String.class);
        return "Cart: " + cartResponse + " | Payment: " + paymentResponse;
    }
}
