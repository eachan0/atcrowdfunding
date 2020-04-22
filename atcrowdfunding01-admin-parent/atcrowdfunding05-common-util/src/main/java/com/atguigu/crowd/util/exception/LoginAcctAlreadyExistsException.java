package com.atguigu.crowd.util.exception;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年04月22日
 * @desc DataAlreadyExistsException 数据已经存在
 */
public class LoginAcctAlreadyExistsException extends RuntimeException{
    private static final long serialVersionUID = -3291621449311864697L;

    public LoginAcctAlreadyExistsException(String message) {
        super(message);
    }
}
