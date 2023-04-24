package com.example.serviceprovider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class GreetingService {

    @Value("${provider.name}")
    private String name;

    public String getGreeting() {
        System.out.println(name + " is being calling!");
        LocalDateTime now = LocalDateTime.now();
        int hour = now.getHour();
        if (hour >= 6 && hour <= 11) {
            return "Good morning!";
        } else if (hour >= 12 && hour <= 17) {
            return "Good afternoon!";
        } else if (hour >= 18 && hour <= 22) {
            return "Good evening!";
        } else {
            return "Good night!";
        }
    }
}
