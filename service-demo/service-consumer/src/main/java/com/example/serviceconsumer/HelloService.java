package com.example.serviceconsumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "service-provider")
public interface HelloService {
    @GetMapping("/greeting")
    String greeting();
}
