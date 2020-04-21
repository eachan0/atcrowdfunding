package com.atguigu.crowd.util.exception;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年04月20日
 * @desc LoginFailedException 自定义登录失败异常
 */
public class LoginFailedException extends RuntimeException{
    private static final long serialVersionUID = -8896571365444746016L;

    public LoginFailedException(String message) {
        super(message);
    }
}
