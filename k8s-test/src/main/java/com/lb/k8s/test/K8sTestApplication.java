package com.lb.k8s.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.lb.k8s.api.feign")
public class K8sTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(K8sTestApplication.class, args);
    }

}
