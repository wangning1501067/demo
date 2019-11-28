package com.test.demo.user.jdbc;

import java.util.List;
import java.util.Map;

public class postgresJDBC2 {
    public static void main(String[] args) throws InterruptedException {
        postgresJDBC p = new postgresJDBC();
        String sql = "select * from economics.\"company_type\"";
        List<Map<String, Object>> list = p.jdbc(sql);
        System.out.println(list);

        String sql2 = "select * from economics.\"register_info\"";
        List<Map<String, Object>> list2 = p.jdbc(sql2);
        System.out.println(list2);
        int num = 1;
        for (Map map : list2) {
//UPDATE "economics"."register_info" SET "company_type_id" = '1' WHERE "id" = 604449
            for (Map map2 : list) {
                if (map.get("QYXZ").toString().equals(map2.get("QYXZ_NAME"))) {
                    System.out.println(num+"======="+map.get("id")+"======UPDATE economics.register_info SET company_type_id = '" + map2.get("id") + "' , two_level_id = 2 , one_level_id = 1 WHERE id = " + map.get("id"));
                    String sql3 = "UPDATE economics.register_info SET three_level_id = '" + map2.get("id") + "' , two_level_id = 2 , one_level_id = 1 WHERE id = " + map.get("id") + ";";
                    List<Map<String, Object>> list3 = p.jdbc2(sql3);
                    System.out.println(list3);
                    Thread.sleep(100);
                    num ++;
                    break;
                }
            }
        }
        System.out.println("===============OK=============");
    }
}