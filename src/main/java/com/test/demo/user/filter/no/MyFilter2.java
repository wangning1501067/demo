package com.test.demo.user.filter.no;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.util.Date;

/**
 *  过滤器 不需要配置
 */
//使用all文件，暂停此文件
//@Component
@Slf4j
public class MyFilter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("time filter start");
        long time = new Date().getTime();
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("time filter :"+(new Date().getTime()-time));
        System.out.println("time filter finish");

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        log.info("请求路径: [{}], 请求的全局id: [{}]", request.getServletPath());
        filterChain.doFilter(new HttpServletRequestWrapper(request), servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("毁灭中...");
    }
}
