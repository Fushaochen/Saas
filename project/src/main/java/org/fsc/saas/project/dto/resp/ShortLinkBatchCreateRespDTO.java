package org.fsc.saas.project.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * ClassName:ShortLinkBatchCreateRespDTO
 * Package:org.fsc.saas.project.dto.resp
 * Description:
 *
 * @Author: fsc
 * @Create: 2025/1/3 - 21:55
 * @Version: v1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShortLinkBatchCreateRespDTO {

    /**
     * 成功数量
     */
    private Integer total;

    /**
     * 批量创建返回参数
     */
    private List<ShortLinkBaseInfoRespDTO> baseLinkInfos;
}