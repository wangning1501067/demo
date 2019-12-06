package com.test.demo.user.jdbc;

import java.io.*;
import java.util.List;
import java.util.Map;

public class postgresJDBC2 {
    public static void main(String[] args) throws InterruptedException, IOException {
        postgresJDBC p = new postgresJDBC();
        String sql = "select * from economics.\"company_type\"";
        List<Map<String, Object>> list = p.jdbc(sql);
        System.out.println(list);

        String sql2 = "select * from economics.\"register_info\" order by id asc";
        List<Map<String, Object>> list2 = p.jdbc(sql2);
        System.out.println(list2);
        int num = 1;

        String filePath="C:\\Users\\Administrator\\Desktop\\sql.txt";
        FileOutputStream fos = new FileOutputStream(filePath);
        for (Map map : list2) {
//UPDATE "economics"."register_info" SET "company_type_id" = '1' WHERE "id" = 604449
            for (Map map2 : list) {
                if (map.get("QYXZ").toString().trim().equals(map2.get("QYXZ_NAME").toString().trim())) {
                    System.out.println(num+"======="+map.get("id")+"======UPDATE economics.register_info SET company_type_id = '" + map2.get("id") + "' , two_level_id = 2 , one_level_id = 1 WHERE id = " + map.get("id"));
                    String sql3 = "UPDATE economics.register_info SET three_level_id = '" + map2.get("id") + "' , two_level_id = 2 , one_level_id = 1 WHERE id = " + map.get("id") + ";";
                    List<Map<String, Object>> list3 = p.jdbc2(sql3);
                    System.out.println(list3);
                    outStr(sql3, fos);
                    Thread.sleep(100);
                    num ++;
                    break;
                }
            }
        }
        fos.close();
        System.out.println("===============OK=============");
    }


    public static void outStr(String str, FileOutputStream fos) throws IOException {
        String restring=str;
        restring+="\r\n";
        fos.write(restring.getBytes());
    }
}