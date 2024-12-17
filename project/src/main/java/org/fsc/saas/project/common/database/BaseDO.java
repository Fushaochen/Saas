package org.fsc.saas.admin.common.database;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;

/**
 * ClassName:BaseDO
 * Package:org.fsc.saas.admin.common.database
 * Description:
 *
 * @Author: fsc
 * @Create: 2024/12/11 - 15:05
 * @Version: v1.0
 */
@Data
public class BaseDO {
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /**
     * 删除标识 0 未删除 1 已删除
     */
    @TableField(fill = FieldFill.INSERT)
    private Integer delFlag;
}
