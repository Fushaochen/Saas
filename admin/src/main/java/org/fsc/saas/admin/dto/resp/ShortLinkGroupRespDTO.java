package org.fsc.saas.admin.dto.resp;

import lombok.Data;

/**
 * ClassName:ShortLinkGroupRespDTO
 * Package:org.fsc.saas.admin.dto.resp
 * Description:
 *
 * @Author: fsc
 * @Create: 2024/12/11 - 15:13
 * @Version: v1.0
 */
@Data
public class ShortLinkGroupRespDTO {

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 分组名称
     */
    private String name;

    /**
     * 分组排序
     */
    private Integer sortOrder;

    /**
     * 分组下短链接的数量
     */
    private Integer shortLinkCount;

}
