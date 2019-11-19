package com.test.demo.user.jiguang.service;

import cn.jpush.api.push.model.PushPayload;
import com.test.demo.user.jiguang.model.PushBean;

/**
 * 极光推送
 * 封装第三方api相关
 */
public interface MyJiGuangPushService {
    boolean pushAll(PushBean pushBean);

    boolean pushIos(PushBean pushBean);

    boolean pushIos(PushBean pushBean, String... registids);

    boolean pushIosByAlias(PushBean pushBean, String... alias);

    boolean pushAndroid(PushBean pushBean);

    boolean pushAndroid(PushBean pushBean, String... registids);

    boolean pushAndroidByAlias(PushBean pushBean, String... alias);

    boolean sendPush(PushPayload pushPayload);
}
