package com.pilllaw.pilllaw.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 모든 엔드포인트에 대해 CORS 허용
        registry.addMapping("/api/**")  // 예: /api/** 경로에 대해
               .allowedOrigins("http://localhost:3000")  // 허용할 출처 (React 앱의 도메인)
               .allowedMethods("GET", "POST", "PUT", "DELETE")  // 허용할 HTTP 메소드
               .allowCredentials(true);  // 자격 증명 허용
    }
}