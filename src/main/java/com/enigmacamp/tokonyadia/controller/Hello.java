package com.enigmacamp.tokonyadia.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class Hello {

    public String hello() {
        return "Req Mapping";

    }

    // Query Param
    @GetMapping("hello")
    //jika mengunakan param dan ingin mendapatkan nama yang di inginkan bisa menggunakan ? setelah mapping dan nama parameternya
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return "Hello " + name;
    }


    // Request Body
    @PostMapping("hello")
    public String helloPost(@RequestBody HashMap<String, String> mapBody) {
        return "Hello Post Method " + mapBody;
    }

    // Path Param
    @GetMapping("hello/{name}")
    public String helloPath(@PathVariable String name) {
        return "Hello Path Parameter " + name;
    }


}
