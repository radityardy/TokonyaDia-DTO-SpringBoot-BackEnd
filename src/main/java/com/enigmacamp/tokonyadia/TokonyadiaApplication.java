package com.enigmacamp.tokonyadia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class TokonyadiaApplication {
    public static void main(String[] args) {
        System.out.println("Tokonyadia Application");
        SpringApplication.run(TokonyadiaApplication.class, args);

    }



}
