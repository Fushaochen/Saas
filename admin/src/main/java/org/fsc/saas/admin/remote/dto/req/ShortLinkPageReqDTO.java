package org.fsc.saas.admin.remote.dto.req;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

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
public class ShortLinkPageReqDTO extends Page {

    private String gid;
}