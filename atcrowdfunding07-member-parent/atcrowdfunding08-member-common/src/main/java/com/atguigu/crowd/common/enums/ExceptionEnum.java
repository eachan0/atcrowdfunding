package com.atguigu.crowd.common.enums;

import cn.hutool.http.HttpStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年05月13日
 * @desc ExceptionEnum 系统异常返回状态和消息枚举
 */
@AllArgsConstructor
public enum ExceptionEnum {
    /**
     * 系统默认异常消息提示
     */
    DEFAULT(HttpStatus.HTTP_INTERNAL_ERROR,"服务器意外错误,请稍后重试"),
    /**
     * 唯一索引不满足
     */
    DUPLICATE_KEY(HttpStatus.HTTP_PRECON_FAILED,"数据已存在"),

    PARAMS_ERROR(HttpStatus.HTTP_BAD_REQUEST,"参数错误");

    @Setter
    @Getter
    private int code;

    @Setter
    @Getter
    private String message;
}
