package org.fsc.saas.project.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.fsc.saas.project.common.convention.result.Result;
import org.fsc.saas.project.dto.req.ShortLinkCreateReqDTO;
import org.fsc.saas.project.dto.resp.ShortLinkCreateRespDTO;

/**
 * ClassName:CustomBlockHandler
 * Package:org.fsc.saas.project.handler
 * Description:
 *
 * @Author: fsc
 * @Create: 2025/1/4 - 17:56
 * @Version: v1.0
 */
public class CustomBlockHandler {

    public static Result<ShortLinkCreateRespDTO> createShortLinkBlockHandlerMethod(ShortLinkCreateReqDTO requestParam, BlockException exception) {
        return new Result<ShortLinkCreateRespDTO>().setCode("B100000").setMessage("当前访问网站人数过多，请稍后再试...");
    }
}
