package org.fsc.saas.admin.controller;

import lombok.RequiredArgsConstructor;
import org.fsc.saas.admin.common.convention.result.Result;
import org.fsc.saas.admin.common.convention.result.Results;
import org.fsc.saas.admin.dto.req.ShortLinkGroupSaveReqDTO;
import org.fsc.saas.admin.service.GroupService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:GroupController
 * Package:org.fsc.saas.admin.controller
 * Description:
 *
 * @Author: fsc
 * @Create: 2024/12/11 - 14:45
 * @Version: v1.0
 */
@RestController
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @PostMapping("/api/saas/v1/group")
    public Result<Void> save(@RequestBody ShortLinkGroupSaveReqDTO requestParam){
        groupService.saveGroup(requestParam.getName());
        return Results.success();
    }
}
