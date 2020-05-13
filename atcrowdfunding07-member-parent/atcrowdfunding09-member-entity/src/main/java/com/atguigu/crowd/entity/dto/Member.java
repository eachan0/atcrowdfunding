package com.atguigu.crowd.entity.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年05月13日
 * @desc Member
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Member implements Serializable {
    private static final long serialVersionUID = -7604949332829716572L;

    @NotBlank(message = "登陆账号")
    private String loginacct;

    @NotBlank(message = "密码")
    private String userpswd;

    @NotBlank(message = "用户名")
    private String username;

    @Email(message = "邮箱格式不正确")
    private String email;

    @NotBlank(message = "手机号")
    @Pattern(regexp = "^1[3456789]\\d{9}$", message = "手机号码不对")
    private String phoneNum;

    @NotBlank(message = "验证码为空")
    private String code;
}
