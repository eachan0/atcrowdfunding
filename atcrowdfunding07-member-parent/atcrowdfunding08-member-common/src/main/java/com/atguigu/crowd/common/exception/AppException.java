package com.atguigu.crowd.common.exception;

import com.atguigu.crowd.common.enums.ExceptionEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年05月13日
 * @desc AppException 系统全局异常
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AppException extends RuntimeException {
    private static final long serialVersionUID = 1777492379633486235L;

    private int code;

    public AppException(int code, String message) {
        super(message);
        this.code = code;
    }

    public AppException(ExceptionEnum ee){
        super(ee.getMessage());
        this.code = ee.getCode();
    }
}
