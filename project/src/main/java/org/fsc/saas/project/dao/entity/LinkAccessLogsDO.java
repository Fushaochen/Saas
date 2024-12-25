package org.fsc.saas.project.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.fsc.saas.project.common.database.BaseDO;

/**
 * ClassName:LinkAccessLogsDO
 * Package:org.fsc.saas.project.dao.entity
 * Description:
 *
 * @Author: fsc
 * @Create: 2024/12/25 - 16:54
 * @Version: v1.0
 */
@Data
@TableName("t_link_access_logs")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LinkAccessLogsDO extends BaseDO {
    /**
     * id
     */
    private Long id;

    /**
     * 完整短链接
     */
    private String fullShortUrl;

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 用户信息
     */
    private String user;

    /**
     * 浏览器
     */
    private String browser;

    /**
     * 操作系统
     */
    private String os;

    /**
     * ip
     */
    private String ip;

    private String network;

    private String device;

    private String locale;
}
