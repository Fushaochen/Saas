package org.fsc.saas.project.dto.req;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import org.fsc.saas.project.dao.entity.ShortLinkDO;

/**
 * ClassName:ShortLinkPageReqDTO
 * Package:org.fsc.saas.project.dto.req
 * Description:
 *
 * @Author: fsc
 * @Create: 2024/12/21 - 14:18
 * @Version: v1.0
 */
@Data
public class ShortLinkPageReqDTO extends Page<ShortLinkDO> {

    private String gid;

    private String orderTag;
}
