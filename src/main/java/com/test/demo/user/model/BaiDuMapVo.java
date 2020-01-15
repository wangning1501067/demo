package com.test.demo.user.model;

import lombok.Data;

import java.util.List;

/**
 * 百度地图信息
 *
 * @date: 2020-01-03
 * @version: 1.0
 * @author: zhangquanshuo@beyondsoft.com
 */
@Data
public class BaiDuMapVo {
    private String name;
    private List<Location> location;
    private String address;
    /**
     * 省
     */
    private String province;
    /**
     * 市
     */
    private String city;
    /**
     * 区
     */
    private String area;
    private String street_id;
    private String telephone;
    private Integer detail;
    private String uid;

}
