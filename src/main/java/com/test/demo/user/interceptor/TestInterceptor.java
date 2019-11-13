package com.test.demo.user.interceptor;

import org.apache.tomcat.util.bcel.Const;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器
 */
@Configuration
public class TestInterceptor implements HandlerInterceptor {

    public TestInterceptor(){}

    // 不验证URL anon：不验证/authc：受控制的
    public static final String NO_INTERCEPTOR_PATH =".*/((.css)|(.js)|(images)|(login)|(anon)).*";

    /**
     * 在请求处理之前进行调用（Controller方法调用之前）
     *
     * preHandle() 方法：该方法会在控制器方法前执行，其返回值表示是否中断后续操作。当其返回值为true时，表示继续向下执行；
     * 当其返回值为false时，会中断后续的所有操作（包括调用下一个拦截器和控制器类中的方法执行等）。
     *
     * 基于URL实现的拦截器
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String queryString = request.getQueryString();
        String requestURL = request.getRequestURL().toString();
        System.out.println("拦截器1，如入参：" + queryString + "访问地址，" + requestURL);

        String path = request.getServletPath();
        if (path.matches(NO_INTERCEPTOR_PATH)) {
            //不需要的拦截直接过
            return true;
        } else {
            // 这写你拦截需要干的事儿，比如取缓存，SESSION，权限判断等
            System.out.println("====================================");
            return true;
        }
        //return true;
    }

    /**
     * postHandle()方法：该方法会在控制器方法调用之后，且解析视图之前执行。可以通过此方法对请求域中的模型和视图做出进一步的修改。
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        System.out.println("拦截器2");
    }

    /**
     * afterCompletion()方法：该方法会在整个请求完成，即视图渲染结束之后执行。可以通过此方法实现一些资源清理、记录日志信息等工作。
     * @param request
     * @param response
     * @param handler
     * @param ex
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)  {
        System.out.println("拦截器3");
    }

}
