package org.fsc.saas.admin.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * ClassName:MyMetaObjectHandler
 * Package:org.fsc.saas.admin.config
 * Description:
 *
 * @Author: fsc
 * @Create: 2024/12/10 - 20:45
 * @Version: v1.0
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        strictInsertFill(metaObject,"createTime", Date::new, Date.class);
        strictInsertFill(metaObject,"updateTime", Date::new, Date.class);
        strictInsertFill(metaObject,"delFlag", () -> 0, Integer.class);

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        strictInsertFill(metaObject,"updateTime", Date::new, Date.class);

    }
}
