package com.test.demo.user.all;

import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 监听器：listener是servlet规范中定义的一种特殊类。用于监听servletContext、HttpSession和servletRequest等域对象的创建和销毁事件。
 * 监听域对象的属性发生修改的事件。用于在事件发生前、发生后做一些必要的处理。其主要可用于以下方面：1、统计在线人数和在线用户2、系统启动时加载初始化信息3、统计网站访问量4、记录用户访问路径。
 *
 * 　　过滤器：Filter是Servlet技术中最实用的技术，Web开发人员通过Filter技术，对web服务器管理的所有web资源：例如Jsp, Servlet, 静态图片文件或静态 html 文件等进行拦截，从而实现一些特殊的功能。
 * 例如实现URL级别的权限访问控制、过滤敏感词汇、压缩响应信息等一些高级功能。它主要用于对用户请求进行预处理，也可以对HttpServletResponse进行后处理。
 * 使用Filter的完整流程：Filter对用户请求进行预处理，接着将请求交给Servlet进行处理并生成响应，最后Filter再对服务器响应进行后处理。
 *
 * 　　拦截器：Interceptor 在AOP（Aspect-Oriented Programming）中用于在某个方法或字段被访问之前，进行拦截然后在之前或之后加入某些操作。
 * 比如日志，安全等。一般拦截器方法都是通过动态代理的方式实现。可以通过它来进行权限验证，或者判断用户是否登陆，或者是像12306 判断当前时间是否是购票时间。
 *  *
 * 　　三大器在springboot中使用时，首先实现相应的接口定义类，然后通过配置类将其加入到spring容器中，从而实现相应的功能。代码如下：
 */
@Configuration
public class MywebConfig implements WebMvcConfigurer {

    /*
    addViewControllers可以方便的实现一个请求直接映射成视图，而无需书写controller
    registry.addViewController("请求路径").setViewName("请求页面文件路径")
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/zxc/foo").setViewName("foo");
    }

    /**
     * 拦截器类
     */
    /*@Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册自定义拦截器，添加拦截路径和排除拦截路径
        registry.addInterceptor(new MyInterceptor())
                //.addPathPatterns("/asd/**");
                .addPathPatterns("/**");
    }*/

    /**
     * 过滤器类
     */
    //@SuppressWarnings({ "rawtypes", "unchecked" })
    /*@Bean
    public FilterRegistrationBean filterRegist() {
        FilterRegistrationBean frBean = new FilterRegistrationBean();
        frBean.setFilter(new MyFilter());
        frBean.addUrlPatterns("/*");
        System.out.println("filter");
        return frBean;
    }*/

    /**
     * 监听器类
     * @return
     */
    //@SuppressWarnings({ "rawtypes", "unchecked" })
    @Bean
    public ServletListenerRegistrationBean listenerRegist() {
        ServletListenerRegistrationBean srb = new ServletListenerRegistrationBean();
        srb.setListener(new MyHttpSessionListener());
        System.out.println("listener");
        return srb;
    }
}
