package org.fsc.saas.admin.dao.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.fsc.saas.admin.common.database.BaseDO;

import java.util.Date;

/**
 * ClassName:UserDao
 * Package:org.fsc.saas.admin.dao.entity
 * Description:
 *
 * @Author: fsc
 * @Create: 2024/12/9 - 10:38
 * @Version: v1.0
 */
@Data
@TableName("t_user")
public class UserDO extends BaseDO {

    /**
     * id
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String mail;

    /**
     * 注销时间戳
     */
    private Long deletionTime;

}
