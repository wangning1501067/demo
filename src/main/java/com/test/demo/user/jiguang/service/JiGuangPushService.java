package com.test.demo.user.jiguang.service;

import com.test.demo.user.jiguang.model.PushBean;

/**
 * 推送服务
 * 封装业务功能相关
 */
public interface JiGuangPushService {
    boolean pushAll(PushBean pushBean);

    boolean pushIos(PushBean pushBean);

    boolean pushIos(PushBean pushBean, String... registids);

    boolean pushIosByAlias(PushBean pushBean, String... alias);

    boolean pushAndroid(PushBean pushBean);

    boolean pushAndroid(PushBean pushBean, String... registids);

    boolean pushAndroidByAlias(PushBean pushBean, String... alias);

    String[] checkRegistids(String[] registids);
}
