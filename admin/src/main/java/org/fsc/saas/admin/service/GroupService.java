package org.fsc.saas.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.fsc.saas.admin.dao.entity.GroupDO;

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
}
