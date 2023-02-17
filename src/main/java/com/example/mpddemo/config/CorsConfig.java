package com.example.mpddemo.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class CorsConfig implements WebMvcConfigurer {
    //通过此配置类可以解决跨域问题
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")//允许跨域访问的路径
                .allowedOrigins("*")//允许跨域访问的源
                .allowedMethods("POST","GET","DELETE","PUT","OPTION")
                .maxAge(168000)//预检测时间间隔
                .allowedHeaders("*")//允许头设置
                .allowCredentials(true);//是否发送cookie
    }
}
