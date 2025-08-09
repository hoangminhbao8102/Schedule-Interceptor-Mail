/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.springbootscheduleinterceptormail.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 *
 * @author 20113
 */
@Configuration
public class SchedulerConfig {
    @Bean
    public ThreadPoolTaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler sch = new ThreadPoolTaskScheduler();
        sch.setPoolSize(5);
        sch.setThreadNamePrefix("sched-");
        sch.setAwaitTerminationSeconds(30);
        sch.setWaitForTasksToCompleteOnShutdown(true);
        return sch;
    }
}
