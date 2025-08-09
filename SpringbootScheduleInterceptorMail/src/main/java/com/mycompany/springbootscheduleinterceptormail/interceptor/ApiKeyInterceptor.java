/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.springbootscheduleinterceptormail.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 *
 * @author 20113
 */
@Component
public class ApiKeyInterceptor implements HandlerInterceptor {

    @Value("${app.security.api-key:}")
    private String apiKey;

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
        if (req.getRequestURI().startsWith("/api/secure")) {
            String header = req.getHeader("X-API-KEY");
            if (header == null || !header.equals(apiKey)) {
                res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                res.getWriter().write("Unauthorized: missing/invalid X-API-KEY");
                return false;
            }
        }
        return true;
    }
}
