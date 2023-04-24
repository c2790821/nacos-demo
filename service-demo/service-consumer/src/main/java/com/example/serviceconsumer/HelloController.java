package com.example.serviceconsumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class HelloController {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    DiscoveryClient discoveryClient;


    @Autowired
    HelloService helloService;

    @GetMapping("/hello")
    public String hello() throws JsonProcessingException {
//        List<ServiceInstance> instances = discoveryClient.getInstances("service-provider");
//        ObjectMapper objectMapper = new ObjectMapper();
//        System.out.println(objectMapper.writeValueAsString(instances));
//        return restTemplate.getForObject("http://service-provider/greeting", String.class);

        return helloService.greeting();
    }
}
