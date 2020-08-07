//package com.test.demo.ip;
//import java.io.BufferedReader;
//import java.io.DataOutputStream;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//public class AddressUtils {
//
//    /**
//     *
//     * @param content
//     *            请求的参数 格式为：name=xxx&pwd=xxx
//     * @param encoding
//     *            服务器端请求编码。如GBK,UTF-8等
//     * @return
//     */
//    public String getAddresses(String content, String encodingString) {
//// 这里调用pconline的接口
//        String urlStr = "http://whois.pconline.sscom.cn/ipJson.jsp";
//// 从http://whois.pconline.com.cn取得IP所在的省市区信息
//        String returnStr = this.getResult(urlStr, content, encodingString);
//        if (returnStr != null) {
//// 处理返回的省市区信息
//            int startIndex = returnStr.indexOf("\"pro");
//            int endIndex = returnStr.indexOf(",\"addr");
//            if (startIndex > 0 && endIndex > 0 && endIndex > startIndex) {
//                returnStr = returnStr.substring(startIndex, endIndex);
//                returnStr = returnStr.replaceAll("\"", "").replace("pro:", "")
//                        .replace("city:", "").replace("region:", "");
//            }
//        }
//        return returnStr;
//    }
//
//    /**
//     * @param urlStr
//     *            请求的地址
//     * @param content
//     *            请求的参数 格式为：name=xxx&pwd=xxx
//     * @param encoding
//     *            服务器端请求编码。如GBK,UTF-8等
//     * @return
//     */
//    private String getResult(String urlStr, String content, String encoding) {
//        URL url = null;
//        HttpURLConnection connection = null;
//        try {
//            url = new URL(urlStr);
//            connection = (HttpURLConnection) url.openConnection();// 新建连接实例
//            connection.setConnectTimeout(2000);// 设置连接超时时间，单位毫秒
//            connection.setReadTimeout(2000);// 设置读取数据超时时间，单位毫秒
//
//            connection.setDoOutput(true);// 是否打开输出流 true|false
//            connection.setDoInput(true);// 是否打开输入流true|false
//            connection.setRequestMethod("POST");// 提交方法POST|GET
//            connection.setUseCaches(false);// 是否缓存true|false
//            connection.connect();// 打开连接端口
//
//            DataOutputStream out = new DataOutputStream(connection
//                    .getOutputStream());// 打开输出流往对端服务器写数据
//            out.writeBytes(content);// 写数据,也就是提交你的表单 name=xxx&pwd=xxx
//            out.flush();// 刷新
//            out.close();// 关闭输出流
//            BufferedReader reader = new BufferedReader(new InputStreamReader(
//                    connection.getInputStream(), encoding));// 往对端写完数据对端服务器返回数据
//// ,以BufferedReader流来读取
//            StringBuffer buffer = new StringBuffer();
//            String line = "";
//            while ((line = reader.readLine()) != null) {
//                buffer.append(line);
//            }
//            reader.close();
//            return buffer.toString();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (connection != null) {
//                connection.disconnect();// 关闭连接
//            }
//        }
//        return null;
//    }
//
//    // 测试
//    public static void main(String[] args) {
//        AddressUtils addressUtils = new AddressUtils();
//// 测试ip
//        String ip = "219.136.134.157";
//        String address = addressUtils.getAddresses("ip=" + ip, "gbk");
//        System.out.println(address);
//// 输出结果为：广东省,广州市,越秀区
//    }
//}
//
//
////乱码解决：
///**
// * 根据坐标泛解析出地址
// *
// * @param itude
// * @return
// * @throws Exception
// */
//private static String getLocationAds(String latitude, String longitude) {
//        JSONObject json = new JSONObject();
//        String resultString = "";
///** 这里采用get方法，直接将参数加到URL上 */
//        String urlString = String.format(
//        " http://maps.google.cn/maps/geo?key=abcdefg&q=%s,%s",
//        latitude, longitude);
//        try {
//        URL url = new URL(urlString);
//        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//        if (conn.getResponseCode() != 200) {
//        System.out.println("链接失败！");
//        return "";
//        }
//        BufferedReader buffReader = new BufferedReader(new InputStreamReader(
//        conn.getInputStream(),"utf-8"));
//        StringBuffer strBuff = new StringBuffer();
//        String result = null;
//        while ((result = buffReader.readLine()) != null) {
//        strBuff.append(result);
//        }
//        resultString = strBuff.toString();
//        System.out.println(resultString);
//
//        } catch (Exception e) {
//// TODO Auto-generated catch block
//        e.printStackTrace();
//        }
//        return resultString;
//
//        }
//public static List<String> pcqLocationAds(String latitude, String longitude)
//        {
//        String province;// 省
//        String cityName;// 市
//        String region;// 地区
//        JSONObject data;
//        List<String> li = new ArrayList<String>();
//        try
//        {
//        String str= ResultUtil.getLocationAds(latitude, longitude);
//        data = new JSONObject(str);
//        data = ((JSONArray) data.get("Placemark")).getJSONObject(0);
//        data = (JSONObject) data.get("AddressDetails");
//        data = (JSONObject) data.get("Country");
//        data = (JSONObject) data.get("AdministrativeArea");
//        province = data.get("AdministrativeAreaName").toString();
//        data = (JSONObject) data.get("Locality");
//        cityName = data.get("LocalityName").toString();
//        data = (JSONObject) data.get("DependentLocality");
//        region = data.get("DependentLocalityName").toString();
//        li.add(province);
//        li.add(cityName);
//        li.add(region);
//        System.out.println(province);
//        System.out.println(cityName);
//        System.out.println(region);
//        }
//        catch (Exception e)
//        {
//        e.printStackTrace();
//        }
//        return li;
//        }
//public static void main(String[] args) {
//        String s= ResultUtil.getLocationAds("34.221379", "108.915555");
//
//        }
