package com.test.demo.user.jiguang.test1;

import com.test.demo.user.jiguang.model.PushBean;
import com.test.demo.user.jiguang.service.JiGuangPushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JiguangTest {

    @Autowired
    private JiGuangPushService jiGuangPushService;

    /**
     * 群推，广播
     *
     * @param title   推送标题
     * @param content 推送内容
     * @return
     */
    @GetMapping("/pushAll")
    public boolean pushAll(@RequestParam String title, @RequestParam String content) {
        PushBean pushBean = new PushBean();
        pushBean.setTitle(title);
        pushBean.setAlert(content);
        boolean flag = jiGuangPushService.pushAndroid(pushBean);
        //return ResultUtil.success(flag);
        return flag;
    }


    /**
     * 单独对regId进行推送
     *
     * @param title   推送标题
     * @param regId   设备对应的唯一极光ID
     * @param content 推送内容
     * @return
     */
    @PostMapping("/push")
    public boolean push(@RequestParam String title, @RequestParam String regId, @RequestParam String content) {
        PushBean pushBean = new PushBean();
        pushBean.setTitle(title);
        pushBean.setAlert(content);
        boolean flag = jiGuangPushService.pushAndroidByAlias(pushBean, regId);
        //return ResultUtil.success(flag);
        return flag;
    }

    /**
     * 单独对regId进行推送
     *
     * @param title   推送标题
     * @param regId   设备对应的唯一极光ID
     * @param content 推送内容
     * @return
     */
    @PostMapping("/pushIOS")
    public boolean pushIOS(@RequestParam String title, @RequestParam String regId, @RequestParam String content) {
        PushBean pushBean = new PushBean();
        pushBean.setTitle(title);
        pushBean.setAlert(content);
        boolean flag = jiGuangPushService.pushIosByAlias(pushBean, regId);
        //return ResultUtil.success(flag);
        return flag;
    }
}
