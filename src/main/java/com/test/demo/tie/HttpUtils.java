package com.test.demo.tie;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 用于模拟HTTP请求中GET/POST方式
 * @author landa
 *
 */
public class HttpUtils {
    /**
     * 发送GET请求
     *
     * @param url 目的地址
     * @param parameters 请求参数，Map类型。
     * @return 远程响应结果
     */
    public static String sendGet(String url, Map<String, String> parameters) {
        String result="";
        BufferedReader in = null;// 读取响应输入流
        StringBuffer sb = new StringBuffer();// 存储参数
        String params = "";// 编码之后的参数
        try {
            // 编码请求参数
            if(parameters.size()==1){
                for(String name:parameters.keySet()){
                    sb.append(name).append("=").append(
                            java.net.URLEncoder.encode(parameters.get(name),
                                    "UTF-8"));
                }
                params=sb.toString();
            }else{
                for (String name : parameters.keySet()) {
                    sb.append(name).append("=").append(
                            java.net.URLEncoder.encode(parameters.get(name),
                                    "UTF-8")).append("&");
                }
                String temp_params = sb.toString();
                params = temp_params.substring(0, temp_params.length() - 1);
            }
            String full_url = url + "?" + params;
            System.out.println(full_url);
            // 创建URL对象
            java.net.URL connURL = new java.net.URL(full_url);
            // 打开URL连接
            java.net.HttpURLConnection httpConn = (java.net.HttpURLConnection) connURL
                    .openConnection();
            // 设置通用属性
            httpConn.setRequestProperty("Accept", "*/*");
            httpConn.setRequestProperty("Connection", "Keep-Alive");
            httpConn.setRequestProperty("User-Agent",
                    "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1)");

            httpConn.setRequestProperty("Cookie",
                    "JSESSIONID=32319E10A675E97142B58AF89F3CDCC2; tk=3PQ3pmL172_zAYczHHTOgt4uyhPPx6bVmr-ewhVonr_yVcpNijw1w0; BIGipServerpool_passport=334299658.50215.0000; route=9036359bb8a8a461c164a04f8f50b252; BIGipServerotn=854589962.64545.0000; _jc_save_fromDate=2020-01-21; _jc_save_fromStation=%u5317%u4EAC%2CBJP; _jc_save_toStation=%u5DE9%u4E49%2CGXF; _jc_save_wfdc_flag=dc; RAIL_EXPIRATION=1577635646898; RAIL_DEVICEID=j0WI0qWB0Alz5_qzgQFsnVfC5zU8D5TUDcn855VfeeHkSnNiVLyZX0d4x2IHyXgbpVQKOOjzrpn8Yk28YPgeI6q2a4S_i_rBXMIt32Q2L4fAmQGOo7ygntIJLocv9tND-oiGy9GToymQebqAfiK06fCMpHXW-8Db; __guid=14023341.3132580092183424500.1577340927295.0046; monitor_count=1; RAIL_EXPIRATION=1577647586628; RAIL_DEVICEID=VEytlnjTj3z4AQL1WHUzqBLxfBWJDo8t5KqyL5vrHSSydZL7ChGKIBbVhnNE_hT53bCBoFoszNtBuEg2b5JQ35yBs9NyrsutBvbryFmVCIeVFqpWYAiH5tKMp8QaUdUL_tgLijuZj0Bc25ZZvGPwnFvC_xbqQQJO; _jc_save_toDate=2019-12-26");

            // 建立实际的连接
            httpConn.connect();
            // 响应头部获取
            Map<String, List<String>> headers = httpConn.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : headers.keySet()) {
                System.out.println(key + "\t：\t" + headers.get(key));
            }
            // 定义BufferedReader输入流来读取URL的响应,并设置编码方式
            in = new BufferedReader(new InputStreamReader(httpConn
                    .getInputStream(), "UTF-8"));
            String line;
            // 读取返回的内容
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result ;
    }

    /**
     * 发送POST请求
     *
     * @param url
     *            目的地址
     * @param parameters
     *            请求参数，Map类型。
     * @return 远程响应结果
     */
    public static String sendPost(String url, Map<String, String> parameters) {
        String result = "";// 返回的结果
        BufferedReader in = null;// 读取响应输入流
        PrintWriter out = null;
        StringBuffer sb = new StringBuffer();// 处理请求参数
        String params = "";// 编码之后的参数
        try {
            // 编码请求参数
            if (parameters.size() == 1) {
                for (String name : parameters.keySet()) {
                    sb.append(name).append("=").append(
                            java.net.URLEncoder.encode(parameters.get(name),
                                    "UTF-8"));
                }
                params = sb.toString();
            } else {
                for (String name : parameters.keySet()) {
                    sb.append(name).append("=").append(
                            java.net.URLEncoder.encode(parameters.get(name),
                                    "UTF-8")).append("&");
                }
                String temp_params = sb.toString();
                params = temp_params.substring(0, temp_params.length() - 1);
            }
            // 创建URL对象
            java.net.URL connURL = new java.net.URL(url);
            // 打开URL连接
            java.net.HttpURLConnection httpConn = (java.net.HttpURLConnection) connURL
                    .openConnection();
            // 设置通用属性
            httpConn.setRequestProperty("Accept", "*/*");
            httpConn.setRequestProperty("Connection", "Keep-Alive");
            httpConn.setRequestProperty("User-Agent",
                    "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1)");
            // 设置POST方式
            httpConn.setDoInput(true);
            httpConn.setDoOutput(true);
            // 获取HttpURLConnection对象对应的输出流
            out = new PrintWriter(httpConn.getOutputStream());
            // 发送请求参数
            out.write(params);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应，设置编码方式
            in = new BufferedReader(new InputStreamReader(httpConn
                    .getInputStream(), "UTF-8"));
            String line;
            // 读取返回的内容
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public static boolean getK819(){
        Map<String, String> parameters = new LinkedHashMap<String, String>();
        parameters.put("leftTicketDTO.train_date", "2019-12-27");
        parameters.put("leftTicketDTO.from_station", "BJP");
        parameters.put("leftTicketDTO.to_station", "GXF");
        parameters.put("purpose_codes", "ADULT");

        //String result =sendGet("http://www.baidu.com", parameters);
        String result =sendGet("https://kyfw.12306.cn/otn/leftTicket/queryZ", parameters);
        System.out.println(result);

        JSONObject json = JSONObject.parseObject(result);
        boolean flag = false;
        if(200 == Integer.valueOf(json.get("httpstatus")+"")){
            JSONObject jsonObject = (JSONObject) json.get("data");
            JSONArray jsonArray = jsonObject.getJSONArray("result");
            System.out.println(jsonArray);

            String str = jsonArray.getString(4);
            System.out.println(str);
            String[] strArray = str.split("[|]");

            /*for (int i = 0; i < strArray.length; i++) {
                System.out.println(i+"===="+strArray[i]);
            }*/

            String s = strArray[26];
            System.out.println(s);
            if(!"无".equals(s)){
                flag = true;
            }
        }
        return flag;
    }

    /**
     * 主函数，测试请求
     *
     * @param args
     */
    public static void main(String[] args) {
        /**
         * HashMap ;无序,高效
         * TreeMap:能够根据主键自动进行排序
         * LinkedHashMap:先进先出...即按照add的先后顺序排序.
         */
        Map<String, String> parameters = new LinkedHashMap<String, String>();
        parameters.put("leftTicketDTO.train_date", "2019-12-27");
        parameters.put("leftTicketDTO.from_station", "BJP");
        parameters.put("leftTicketDTO.to_station", "GXF");
        parameters.put("purpose_codes", "ADULT");

        //String result =sendGet("http://www.baidu.com", parameters);
        String result =sendGet("https://kyfw.12306.cn/otn/leftTicket/queryZ", parameters);
        System.out.println(result);

        JSONObject json = JSONObject.parseObject(result);
        if(200 == Integer.valueOf(json.get("httpstatus")+"")){
            JSONObject jsonObject = (JSONObject) json.get("data");
            JSONArray jsonArray = jsonObject.getJSONArray("result");
            System.out.println(jsonArray);

            String str = jsonArray.getString(4);
            System.out.println(str);
            String[] strArray = str.split("[|]");

            /*for (int i = 0; i < strArray.length; i++) {
                System.out.println(i+"===="+strArray[i]);
            }*/

            String s = strArray[26];
            System.out.println(s);
        }
    }
}
