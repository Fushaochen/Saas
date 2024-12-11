package org.fsc.saas.admin.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * ClassName:GroupDO
 * Package:org.fsc.saas.admin.dao.entity
 * Description:
 *
 * @Author: fsc
 * @Create: 2024/12/11 - 14:41
 * @Version: v1.0
 */
@Data
@TableName("t_group")
public class GroupDO {
    /**
     * id
     */
    private long id;

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 分组名称
     */
    private String name;

    /**
     * 创建分组用户名
     */
    private String username;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 删除标识 0：未删除 1：已删除
     */
    private int delFlag;

}