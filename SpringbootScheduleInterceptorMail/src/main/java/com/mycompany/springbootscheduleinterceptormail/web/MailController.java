/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.springbootscheduleinterceptormail.web;

import com.mycompany.springbootscheduleinterceptormail.mail.MailService;
import jakarta.mail.MessagingException;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.context.Context;

import java.time.ZonedDateTime;
import java.util.Map;

/**
 *
 * @author 20113
 */
@RestController
@RequestMapping("/api/mail")
@Validated
public class MailController {

    private final MailService mailService;

    // Constructor injection (không dùng Lombok)
    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @PostMapping("/simple")
    public Map<String, Object> sendSimple(@RequestBody @Validated SimpleMailReq req) {
        mailService.sendSimple(req.getTo(), req.getSubject(), req.getText());
        return Map.of("sent", true);
    }

    @PostMapping("/html")
    public Map<String, Object> sendHtml(@RequestBody @Validated HtmlMailReq req) throws MessagingException {
        mailService.sendHtml(req.getTo(), req.getSubject(), req.getHtml());
        return Map.of("sent", true);
    }

    @PostMapping("/welcome")
    public Map<String, Object> sendWelcome(@RequestBody @Validated WelcomeMailReq req) throws MessagingException {
        Context ctx = new Context();
        ctx.setVariable("name", req.getName());
        ctx.setVariable("serverTime", ZonedDateTime.now().toString());
        mailService.sendTemplate(req.getTo(), "Welcome, " + req.getName() + "!", "email/welcome", ctx);
        return Map.of("sent", true);
    }

    // ===== DTOs không dùng Lombok: cần no-args constructor + getters/setters =====
    public static class SimpleMailReq {
        @Email @NotBlank private String to;
        @NotBlank private String subject;
        @NotBlank private String text;

        public SimpleMailReq() { }
        public String getTo() { return to; }
        public void setTo(String to) { this.to = to; }
        public String getSubject() { return subject; }
        public void setSubject(String subject) { this.subject = subject; }
        public String getText() { return text; }
        public void setText(String text) { this.text = text; }
    }

    public static class HtmlMailReq {
        @Email @NotBlank private String to;
        @NotBlank private String subject;
        @NotBlank private String html;

        public HtmlMailReq() { }
        public String getTo() { return to; }
        public void setTo(String to) { this.to = to; }
        public String getSubject() { return subject; }
        public void setSubject(String subject) { this.subject = subject; }
        public String getHtml() { return html; }
        public void setHtml(String html) { this.html = html; }
    }

    public static class WelcomeMailReq {
        @Email @NotBlank private String to;
        @NotBlank private String name;

        public WelcomeMailReq() { }
        public String getTo() { return to; }
        public void setTo(String to) { this.to = to; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
    }
}
