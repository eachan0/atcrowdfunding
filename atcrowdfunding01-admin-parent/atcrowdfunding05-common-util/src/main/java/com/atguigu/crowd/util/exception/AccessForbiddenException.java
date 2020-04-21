package com.atguigu.crowd.util.exception;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年04月21日
 * @desc AccessForbiddenException
 */
public class AccessForbiddenException extends RuntimeException{
    private static final long serialVersionUID = -4237922359620589607L;

    public AccessForbiddenException(String message) {
        super(message);
    }
}
