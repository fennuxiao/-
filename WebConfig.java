package com.example.health.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
// 引入 WebMvcConfigurer 接口
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 全局配置类，用于跨域访问
@Configuration
// 实现 WebMvcConfigurer 接口
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        /**
         * 1.与访问路径
         * 2.请求来源
         * 3.请求方法
         * 4.是否允许携带
         * 5.最大时间
         **/
        registry.addMapping("/**") // 允许跨域访问的路径
                .allowedOrigins("Http://localhost:8080", "null") // 允许跨域访问的来源
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE") // 允许跨域的请求方法
                .allowCredentials(true)
                .maxAge(3600);
    }
}