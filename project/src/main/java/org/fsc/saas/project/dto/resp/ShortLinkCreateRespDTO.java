package org.fsc.saas.project.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShortLinkCreateRespDTO {


    private String gid;
    /**
     * 域名
     */
    private String domain;

    /**
     * 原始链接
     */
    private String originUrl;


    private String fullShortUrl;


}
