package com.test.demo.security.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysUserRole implements Serializable {
    static final long serialVersionUID = 1L;

    private Integer user_Id;

    private Integer role_Id;

// 省略getter/setter
}
