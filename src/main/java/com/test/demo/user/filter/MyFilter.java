package com.test.demo.user.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.util.Date;

/**
 *  过滤器         spring自己的可以用 component注解 来注入,如果是第三方就需要从新 通过 配置类来注入,config中
 *
 *  缺点 :可以拿到http请求的原始信息,但是拿不到真正处理这个请求的方法信息
 */
//@Component
@Slf4j
public class MyFilter implements Filter {
    //@Override
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
