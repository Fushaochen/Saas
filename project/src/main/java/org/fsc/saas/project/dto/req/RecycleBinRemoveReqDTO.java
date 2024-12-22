package org.fsc.saas.project.dto.req;

import lombok.Data;

/**
 * ClassName:RecycleBinSaveReqDTO
 * Package:org.fsc.saas.project.dto.req
 * Description:
 *
 * @Author: fsc
 * @Create: 2024/12/22 - 15:21
 * @Version: v1.0
 */
@Data
public class RecycleBinRemoveReqDTO {

    private String gid;

    private String fullShortUrl;
}
