package com.test.demo.user.jdbc;

import com.google.common.collect.Lists;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class postgresJDBC {

    /**
     * @param args
     */
    public static List<Map<String, Object>> jdbc(String sql){
        ResultSet rs = null;
        List<Map<String, Object>> list = Lists.newArrayList();
// TODO Auto-generated method stub
        try{
            Class.forName("org.postgresql.Driver").newInstance();
            String connectUrl ="jdbc:postgresql://192.168.7.160:5432/bys_iot";
            Connection conn = DriverManager.getConnection(connectUrl,"bys","bys2018");
            Statement st = conn.createStatement();
            //String sql =" SELECT 1;";
            rs = st.executeQuery(sql);
            /*while(rs.next()){
                System.out.println(rs.getString(1));
            }*/
            ResultSetMetaData md = rs.getMetaData(); //获得结果集结构信息,元数据
            int columnCount = md.getColumnCount();   //获得列数
            while (rs.next()) {
                Map<String,Object> rowData = new HashMap<String,Object>();
                for (int i = 1; i <= columnCount; i++) {
                    rowData.put(md.getColumnName(i), rs.getObject(i));
                }
                list.add(rowData);

            }
            rs.close();
            st.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        String sql = "select * from economics.\"Provinces\"";
        List<Map<String, Object>> list = jdbc(sql);
        System.out.println(list);

        String sql2 = "select * from economics.prov_city_dist";
        List<Map<String, Object>> list2 = jdbc(sql2);
        System.out.println(list2);

        for (Map map:list) {
            //System.out.println(map);
            boolean flag = false;
            for (Map map2:list2) {
                //System.out.println(map);
                if(map.get("name").equals(map2.get("AREA_NAME"))){
                    flag=true;
                    if(!map.get("code").toString().equals(map2.get("AREA_CODE").toString())){
                        System.out.println(map.get("name")+"===>"+map.get("code")+"=============="+map2.get("AREA_NAME")+"===>"+map2.get("AREA_CODE"));
                        break;
                    }
                }else{
                    continue;
                }
            }
            /*if(flag){
                System.out.println(map.get("name")+"===>"+map.get("code"));
            }*/
        }
    }
}
