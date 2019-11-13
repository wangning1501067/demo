//package com.test.demo.user.filter;
//
//import com.google.common.collect.Lists;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.List;
//
////使用all文件，暂停此文件
//@Configuration
//public class FilterConfig {
//    @Bean
//    public FilterRegistrationBean filterRegistrationBean() {
//        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
//        registrationBean.setFilter(new MyFilter()); // 自己的filter
//
//        List<String> urlPatterns = Lists.newArrayList();
//        urlPatterns.add("/*");
//        registrationBean.setUrlPatterns(urlPatterns);
//        return registrationBean;
//    }
//}
