package com.test.demo.user.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.test.demo.user.model.BaiDuMapVo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

/**
 * 百度地图api
 *
 * @date: 2020-01-02
 * @version: 1.0
 * @author: zhangquanshuo@beyondsoft.com
 */
public class BaiDuMapUtil {

    //ak:BCKWnLGe1dRoS3w4lE0wIalzukmBwOdK
    public static String getResponse(String serverUrl) {
        //用JAVA发起http请求，并返回json格式的结果
        StringBuffer result = new StringBuffer();
        try {
            URL url = new URL(serverUrl);
            URLConnection conn = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
            in.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public static void main(String[] args) {
        /**
         * 行政区划区域检索
         * http://api.map.baidu.com/place/v2/search?query=ATM机&tag=银行&region=北京&output=json&ak=BCKWnLGe1dRoS3w4lE0wIalzukmBwOdK
         */
        String url1 = "http://api.map.baidu.com/place/v2/search?query=公司企业&tag=公司&region=北京市海淀区&output=json&ak=BCKWnLGe1dRoS3w4lE0wIalzukmBwOdK";
        //String url2="http://api.map.baidu.com/place/v2/search?query=公司企业&location=30.659462,104.065735&radius=2000&output=json&ak=BCKWnLGe1dRoS3w4lE0wIalzukmBwOdK&page_num=0&page_size=20";
        String url3 = "http://api.map.baidu.com/place/v2/suggestion?query=博彦科技&region=全国&city_limit=false&output=json&ak=BCKWnLGe1dRoS3w4lE0wIalzukmBwOdK";
        String res = getResponse(url3);
        JSONObject jsonObject = JSONObject.parseObject(res);
        List<BaiDuMapVo> resultData = JSON.parseArray(JSON.toJSONString(jsonObject.get("results")), BaiDuMapVo.class);

    }
}
