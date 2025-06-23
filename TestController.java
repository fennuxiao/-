package com.example.health.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class TestController {
    @RequestMapping("/test")
    public String test() {
        return "ok";
    }

}
