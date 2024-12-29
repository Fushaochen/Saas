package org.fsc.saas.project.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import groovy.transform.Internal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.fsc.saas.project.common.database.BaseDO;

import java.util.Date;

/**
 * ClassName:LinkDO
 * Package:org.fsc.saas.project.dao.entity
 * Description:
 *
 * @Author: fsc
 * @Create: 2024/12/17 - 16:50
 * @Version: v1.0
 */
@Data
@TableName("t_link")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShortLinkDO extends BaseDO {

    private Long id;

    /**
     * 域名
     */
    private String domain;

    /**
     * 短链接
     */
    private String shortUri;

    /**
     * 完整短链接
     */
    private String fullShortUrl;

    /**
     * 原始链接
     */
    private String originUrl;

    /**
     * 点击量
     */
    private Integer clickNum;

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 启用标识 0：未启用 1：已启用
     */
    private Integer enableStatus;

    /**
     * 创建类型 0：控制台 1：接口
     */
    private Integer createdType;

    /**
     * 有效期类型 0：永久有效 1：用户自定义
     */
    private Integer validDateType;

    /**
     * 有效期
     */
    private Date validDate;

    /**
     * 描述
     */
    @TableField("`describe`")
    private String describe;

    /**
     * 网站标识
     */
    private String favicon;

    private Integer totalPv;

    @TableField(exist = false)
    private Integer todayPv;

    private Integer totalUv;

    @TableField(exist = false)
    private Integer todayUv;

    private Integer totalUip;

    @TableField(exist = false)
    private Integer todayUip;

}
