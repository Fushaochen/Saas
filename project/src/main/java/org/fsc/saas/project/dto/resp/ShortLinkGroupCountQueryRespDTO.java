package org.fsc.saas.project.dto.resp;

import lombok.Data;

/**
 * ClassName:ShortLinkCountQueryReqDTO
 * Package:org.fsc.saas.project.dto.resp
 * Description:
 *
 * @Author: fsc
 * @Create: 2024/12/21 - 15:39
 * @Version: v1.0
 */
@Data
public class ShortLinkGroupCountQueryRespDTO {

    private String gid;

    private Integer shortLinkCount;
}
