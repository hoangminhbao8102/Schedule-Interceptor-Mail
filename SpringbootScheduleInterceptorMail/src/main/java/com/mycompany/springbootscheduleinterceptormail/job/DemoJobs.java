/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.springbootscheduleinterceptormail.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

/**
 *
 * @author 20113
 */
@Component
public class DemoJobs {

    private static final Logger log = LoggerFactory.getLogger(DemoJobs.class);

    // Mỗi 10 giây 1 lần
    @Scheduled(fixedRate = 10_000)
    public void heartbeat() {
        log.info("[heartbeat] {}", ZonedDateTime.now());
    }

    // 09:00:00 mỗi ngày (cron Spring: second minute hour day-of-month month day-of-week)
    @Scheduled(cron = "0 0 9 * * *", zone = "Asia/Ho_Chi_Minh")
    public void dailyReport() {
        log.info("[dailyReport] Run @ 09:00 Asia/Ho_Chi_Minh - generate or email a report...");
        // TODO: gọi MailService nếu cần
    }
}
