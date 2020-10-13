package com.example.consumer9001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class Consumer9001Application {

    public static void main(String[] args) {
        SpringApplication.run(Consumer9001Application.class, args);
    }

}
