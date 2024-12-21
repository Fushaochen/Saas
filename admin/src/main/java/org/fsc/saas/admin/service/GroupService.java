package org.fsc.saas.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.fsc.saas.admin.dao.entity.GroupDO;
import org.fsc.saas.admin.dto.req.ShortLinkGroupSaveReqDTO;
import org.fsc.saas.admin.dto.req.ShortLinkGroupSortReqDTO;
import org.fsc.saas.admin.dto.req.ShortLinkGroupUpdateReqDTO;
import org.fsc.saas.admin.dto.resp.ShortLinkGroupRespDTO;

import java.util.List;

/**
 * ClassName:GroupService
 * Package:org.fsc.saas.admin.service
 * Description:
 *
 * @Author: fsc
 * @Create: 2024/12/11 - 14:43
 * @Version: v1.0
 */
public interface GroupService extends IService<GroupDO> {


    void saveGroup(String groupName);


    void saveGroup(String username, String groupName);



    List<ShortLinkGroupRespDTO> listGroup();

    void updateGroup(ShortLinkGroupUpdateReqDTO requestParam);

    void deleteGroup(String gid);

    void sortGroup(List<ShortLinkGroupSortReqDTO> requestParam);
}
