package com.test.demo.security.exception;

import lombok.Data;

/**
 * 通用异常定义
 *
 * @date: 2018-10-19
 * @version: 1.0
 * @author: robin.luo@beyondsoft.com
 */
@Data
public class BaseResponse {

    private int status = 200;
    private Object message = "ok";
    private String messageKey = "";

    public BaseResponse(int status, Object message) {
        this.status = status;
        this.message = message;
    }

    public BaseResponse(int status, String messageKey, String message) {
        this.status = status;
        this.messageKey = messageKey;
        this.message = message;
    }

    public BaseResponse() {
    }
}
