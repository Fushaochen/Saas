package org.fsc.saas.admin.remote.dto.req;

import lombok.Data;

/**
 * ClassName:ShortLinkGroupStatsReqDTO
 * Package:org.fsc.saas.project.dto.req
 * Description:
 *
 * @Author: fsc
 * @Create: 2024/12/29 - 20:33
 * @Version: v1.0
 */
@Data
public class ShortLinkGroupStatsReqDTO {

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 开始日期
     */
    private String startDate;

    /**
     * 结束日期
     */
    private String endDate;
}
