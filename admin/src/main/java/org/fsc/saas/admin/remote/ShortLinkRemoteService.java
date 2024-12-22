package org.fsc.saas.admin.remote;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.fsc.saas.admin.common.convention.result.Result;
import org.fsc.saas.admin.dto.req.RecycleBinSaveReqDTO;
import org.fsc.saas.admin.remote.dto.req.ShortLinkCreateReqDTO;
import org.fsc.saas.admin.remote.dto.req.ShortLinkPageReqDTO;
import org.fsc.saas.admin.remote.dto.req.ShortLinkRecycleBinPageReqDTO;
import org.fsc.saas.admin.remote.dto.req.ShortLinkUpdateDTO;
import org.fsc.saas.admin.remote.dto.resp.ShortLinkCreateRespDTO;
import org.fsc.saas.admin.remote.dto.resp.ShortLinkGroupCountQueryRespDTO;
import org.fsc.saas.admin.remote.dto.resp.ShortLinkPageRespDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        requestMap.put("size", requestParam.getSize());
        String resultPage = HttpUtil.get("http://127.0.0.1:8001/api/saas/v1/page", requestMap);

        return JSON.parseObject(resultPage, new TypeReference<>() {
        });
    }

    default Result<ShortLinkCreateRespDTO> createShortLink(ShortLinkCreateReqDTO requestParam){
        String resultBodyStr = HttpUtil.post("http://127.0.0.1:8001/api/saas/v1/create", JSON.toJSONString(requestParam));
        return JSON.parseObject(resultBodyStr, new TypeReference<>() {
        });
    }

    default Result<List<ShortLinkGroupCountQueryRespDTO>> listGroupShortLinkCount(List<String> requestParam){
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("requestParam",requestParam);
        String resultPage = HttpUtil.get("http://127.0.0.1:8001/api/saas/v1/count", requestMap);
        return JSON.parseObject(resultPage, new TypeReference<>() {
        });
    }

    default void updateShortLink(ShortLinkUpdateDTO requestParam){
        String resultBodyStr = HttpUtil.post("http://127.0.0.1:8001/api/saas/v1/update", JSON.toJSONString(requestParam));
    }

    default Result<String> getTitleByUrl(String url){
        String resultStr = HttpUtil.get("http://127.0.0.1:8001/api/saas/v1/title?url=" + url);
        return JSON.parseObject(resultStr, new TypeReference<>() {
        });
    }

    default void saveRecycleBin(RecycleBinSaveReqDTO requestParam){
        HttpUtil.post("http://127.0.0.1:8001/api/saas/v1/recycle-bin/save", JSON.toJSONString(requestParam));

    }

    default Result<IPage<ShortLinkPageRespDTO>> pageRecycleBinShortLink(ShortLinkRecycleBinPageReqDTO requestParam){
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("gidList", requestParam.getGidList());
        requestMap.put("current", requestParam.getCurrent());
        requestMap.put("size", requestParam.getSize());
        String resultPage = HttpUtil.get("http://127.0.0.1:8001/api/saas/v1/recycle-bin/page", requestMap);

        return JSON.parseObject(resultPage, new TypeReference<>() {
        });
    }
}
