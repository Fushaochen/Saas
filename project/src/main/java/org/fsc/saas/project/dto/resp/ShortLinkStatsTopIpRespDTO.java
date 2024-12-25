package org.fsc.saas.project.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName:ShortLinkStatsTopIpRespDTO
 * Package:org.fsc.saas.project.dto.resp
 * Description:
 *
 * @Author: fsc
 * @Create: 2024/12/25 - 20:29
 * @Version: v1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShortLinkStatsTopIpRespDTO {

    /**
     * 统计
     */
    private Integer cnt;

    /**
     * IP
     */
    private String ip;
}
