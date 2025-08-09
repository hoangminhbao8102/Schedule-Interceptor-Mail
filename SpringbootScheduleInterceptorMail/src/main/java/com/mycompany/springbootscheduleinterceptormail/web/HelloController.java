/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.springbootscheduleinterceptormail.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.util.Map;

/**
 *
 * @author 20113
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public Map<String, Object> hello() {
        return Map.of(
            "message", "Hello from Spring Boot!",
            "time", ZonedDateTime.now().toString()
        );
    }

    @GetMapping("/api/secure/ping")
    public Map<String, Object> securePing() {
        return Map.of("secure", true, "ok", true);
    }
}
