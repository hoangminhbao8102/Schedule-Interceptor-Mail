/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.springbootscheduleinterceptormail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 *
 * @author 20113
 */
@SpringBootApplication
@EnableScheduling
public class SimDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SimDemoApplication.class, args);
    }
}
