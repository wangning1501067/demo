package com.test.demo.security.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 通用异常定义
 *
 * @date: 2018-10-19
 * @version: 1.0
 * @author: robin.luo@beyondsoft.com
 */
@ControllerAdvice("com.test.demo")
@ResponseBody
@Slf4j
public class GeneralExceptionHandler {

    @ExceptionHandler(Exception.class)
    public BaseResponse otherExceptionHandler(HttpServletResponse response, Exception ex, HttpServletRequest request){
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        log.error(ex.getMessage(),ex);
        return new BaseResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
    }
}

