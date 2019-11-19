package com.test.demo.user.model;

import lombok.Data;

import java.util.Date;

@Data
public class ChinaDate {
    /**
     * 公历时间
     */
    private Date solarDate;
    /**
     * 农历日
     */
    private String lunar;
    /**
     * 公历日
     */
    private String solar;
    /**
     * 是否是 休
     */
    private boolean isVacation = false;
    /**
     * 如果是 休情况下的假期名字
     */
    private String VacationName = "非假期";
    /**
     * 是否是 班
     */
    private boolean isWorkFlag = false;
    private boolean isSaturday = false;
    private boolean isSunday = false;

}
