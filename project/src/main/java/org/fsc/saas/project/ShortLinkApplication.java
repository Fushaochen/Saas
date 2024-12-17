package org.fsc.saas.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ClassName:ShortLinkApplication
 * Package:org.fsc.saas.project
 * Description:
 *
 * @Author: fsc
 * @Create: 2024/12/17 - 16:57
 * @Version: v1.0
 */
@SpringBootApplication
@MapperScan("org.fsc.saas.project.dao.mapper")
public class ShortLinkApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShortLinkApplication.class,args);
    }
}
