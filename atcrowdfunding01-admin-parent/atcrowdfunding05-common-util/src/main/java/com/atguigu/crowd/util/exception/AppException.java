package com.atguigu.crowd.util.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年04月20日
 * @desc AppException
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AppException extends RuntimeException {
    private static final long serialVersionUID = 1777492379633486235L;

    private int code;

    public AppException(int code,String message) {
        super(message);
        this.code = code;
    }
}
