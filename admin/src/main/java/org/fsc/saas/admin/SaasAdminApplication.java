package org.fsc.saas.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ClassName:SaasAdminApplication
 * Package:org.fsc.saas.admin
 * Description:
 *
 * @Author: fsc
 * @Create: 2024/12/8 - 11:20
 * @Version: v1.0
 */
@SpringBootApplication
@MapperScan("org.fsc.saas.admin.dao.mapper")
public class SaasAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(SaasAdminApplication.class,args);
    }
}
