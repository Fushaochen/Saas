package org.fsc.saas.admin.controller;

import lombok.RequiredArgsConstructor;
import org.fsc.saas.admin.common.convention.result.Result;
import org.fsc.saas.admin.common.convention.result.Results;
import org.fsc.saas.admin.dto.req.ShortLinkGroupSaveReqDTO;
import org.fsc.saas.admin.dto.req.ShortLinkGroupSortReqDTO;
import org.fsc.saas.admin.dto.req.ShortLinkGroupUpdateReqDTO;
import org.fsc.saas.admin.dto.resp.ShortLinkGroupRespDTO;
import org.fsc.saas.admin.service.GroupService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/api/saas/admin/v1/group")
    public Result<Void> save(@RequestBody ShortLinkGroupSaveReqDTO requestParam){
        groupService.saveGroup(requestParam.getName());
        return Results.success();
    }

    @GetMapping("/api/saas/admin/v1/group")
    public Result<List<ShortLinkGroupRespDTO>> listGroup(){
        return Results.success(groupService.listGroup());
    }

    @PutMapping("/api/saas/admin/v1/group")
    public Result<Void> updateGroup(@RequestBody ShortLinkGroupUpdateReqDTO requestParam){
        groupService.updateGroup(requestParam);
        return Results.success();
    }

    @DeleteMapping("/api/saas/admin/v1/group")
    public Result<Void> deleteGroup(@RequestParam String gid){
        groupService.deleteGroup(gid);
        return Results.success();
    }

    @PostMapping("/api/saas/admin/v1/group/sort")
    public Result<Void> sortGroup(@RequestBody List<ShortLinkGroupSortReqDTO> requestParam){
        groupService.sortGroup(requestParam);
        return Results.success();
    }
}
