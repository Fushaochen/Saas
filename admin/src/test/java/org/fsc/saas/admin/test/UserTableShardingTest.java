package org.fsc.saas.admin.test;

/**
 * ClassName:UserTableShardingTest
 * Package:org.fsc.saas.admin.test
 * Description:
 *
 * @Author: fsc
 * @Create: 2024/12/10 - 22:22
 * @Version: v1.0
 */
public class UserTableShardingTest {

    public static final String SQL = "ALTER TABLE t_link_%d\n" +
            "ADD COLUMN favicon VARCHAR(256) COMMENT '网站图标'";

    public static void main(String[] args) {
        for(int i = 0; i < 16 ; i++){
            System.out.printf((SQL) + "%n", i);
        }
    }
}
