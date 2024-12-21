package org.fsc.saas.admin.remote.dto;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.fsc.saas.admin.common.convention.result.Result;
import org.fsc.saas.admin.remote.dto.req.ShortLinkCreateReqDTO;
import org.fsc.saas.admin.remote.dto.req.ShortLinkPageReqDTO;
import org.fsc.saas.admin.remote.dto.resp.ShortLinkCreateRespDTO;
import org.fsc.saas.admin.remote.dto.resp.ShortLinkPageRespDTO;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * ClassName:ShortLinkRemoteService
 * Package:org.fsc.saas.admin.remote.dto
 * Description:
 *
 * @Author: fsc
 * @Create: 2024/12/21 - 14:50
 * @Version: v1.0
 */
public interface ShortLinkRemoteService {

    default Result<IPage<ShortLinkPageRespDTO>> pageShortLink(ShortLinkPageReqDTO requestParam){
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("gid",requestParam.getGid());
        requestMap.put("current", requestParam.getCurrent());
        requestMap.put("size", requestParam.getCurrent());
        String resultPage = HttpUtil.get("http://127.0.0.1:8001/api/saas/v1/page", requestMap);

        return JSON.parseObject(resultPage, new TypeReference<Result<IPage<ShortLinkPageRespDTO>>>() {
        });
    }

    default Result<ShortLinkCreateRespDTO> createShortLink(ShortLinkCreateReqDTO requestParam){
        String resultBodyStr = HttpUtil.post("http://127.0.0.1:8001/api/saas/v1/create", JSON.toJSONString(requestParam));
        return JSON.parseObject(resultBodyStr, new TypeReference<Result<ShortLinkCreateRespDTO>>() {
        });

    }
}
