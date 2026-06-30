package com.example.demo;

import java.util.concurrent.CompletableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncAndsyncController {

    // Simulates lift taking 3 seconds to arrive
    private String getLift() {
        try {
            Thread.sleep(3000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Lift has arrived at Ground Floor!";
    }

    // 1. Synchronous (Blocking): Browser spins for 3 seconds waiting.
    @GetMapping("/lift/sync")
    public String callLiftSync() {
        return getLift(); 
    }

    // 2. Asynchronous (Non-Blocking): Browser returns instantly.
    @GetMapping("/lift/async")
    public String callLiftAsync() {
        CompletableFuture.runAsync(() -> {
            String result = getLift(); // Waits in background
            System.out.println("🔔 Notification: " + result);
        });
        
        return "Lift called! You can play on your phone now."; 
    }
}
