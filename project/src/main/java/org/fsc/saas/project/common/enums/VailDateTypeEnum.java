package org.fsc.saas.project.common.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * ClassName:VailDateTypeEnum
 * Package:org.fsc.saas.project.common.enums
 * Description:
 *
 * @Author: fsc
 * @Create: 2024/12/21 - 19:39
 * @Version: v1.0
 */
@RequiredArgsConstructor
public enum VailDateTypeEnum {

    PERMANENT(0),
    CUSTOM(1);

    @Getter
    private final int type;

}
