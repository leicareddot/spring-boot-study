package com.atoz_develop.springbootandspringwebmvc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    // 정적 리소스 핸들러 추가
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/m/**")    // URL 매핑
                .addResourceLocations("classpath:/m/")  // 로케이션 - 반드시 '/'로 끝나야 함
                .setCachePeriod(20);    // Optional
    }
}
