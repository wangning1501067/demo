//package com.test.demo.user.interceptor;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//
///**
// * 注册拦截器
// */
////使用all文件，暂停此文件
//@Configuration
//public class WebMvcConfg extends WebMvcConfigurationSupport {
//
//    @Autowired
//    private TestInterceptor interceptorConfig;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        //注册自定义拦截器，添加拦截路径和排除拦截路径
//        registry.addInterceptor(interceptorConfig).addPathPatterns("/**");
//    }
//
//}