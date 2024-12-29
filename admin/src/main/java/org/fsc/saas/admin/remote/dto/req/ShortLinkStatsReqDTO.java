package org.fsc.saas.admin.remote.dto.req;

import lombok.Data;

/**
 * ClassName:ShortLinkStatsReqDTO
 * Package:org.fsc.saas.project.dto.req
 * Description:
 *
 * @Author: fsc
 * @Create: 2024/12/25 - 20:12
 * @Version: v1.0
 */
@Data
public class ShortLinkStatsReqDTO {

    private String fullShortUrl;

    private String gid;

    private String startDate;

    private String endDate;

    private Integer enableStatus;
}
