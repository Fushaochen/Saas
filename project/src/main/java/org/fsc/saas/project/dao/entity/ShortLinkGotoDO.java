package org.fsc.saas.project.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName:ShortLinkGoToDO
 * Package:org.fsc.saas.project.dao.entity
 * Description:
 *
 * @Author: fsc
 * @Create: 2024/12/21 - 20:53
 * @Version: v1.0
 */
@Data
@TableName("t_link_goto")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShortLinkGotoDO {

    private Long id;

    private String gid;

    private String fullShortUrl;
}
