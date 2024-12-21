package org.fsc.saas.admin.remote.dto.req;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * ClassName:ShortLinkCreateReqDTO
 * Package:org.fsc.saas.project.dto.req
 * Description:
 *
 * @Author: fsc
 * @Create: 2024/12/17 - 17:09
 * @Version: v1.0
 */
@Data
public class ShortLinkCreateReqDTO {


    /**
     * 域名
     */
    private String domain;


    /**
     * 原始链接
     */
    private String originUrl;


    /**
     * 分组标识
     */
    private String gid;



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
    @JsonFormat(pattern = "yyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date validDate;

    /**
     * 描述
     */

    private String describe;

}
