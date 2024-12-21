package org.fsc.saas.project.dto.resp;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * ClassName:ShortLinkPageRespDTO
 * Package:org.fsc.saas.project.dto.resp
 * Description:
 *
 * @Author: fsc
 * @Create: 2024/12/21 - 14:19
 * @Version: v1.0
 */
@Data
public class ShortLinkPageRespDTO {

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
     * 分组标识
     */
    private String gid;

    /**
     * 有效期类型 0：永久有效 1：用户自定义
     */
    private Integer validDateType;

    /**
     * 有效期
     */
    @JsonFormat(pattern = "yyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date validDate;

    @JsonFormat(pattern = "yyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    /**
     * 描述
     */
    private String describe;

    /**
     * 网站标识
     */
    private String favicon;
}
