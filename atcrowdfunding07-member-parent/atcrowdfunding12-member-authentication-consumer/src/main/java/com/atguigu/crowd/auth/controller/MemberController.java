package com.atguigu.crowd.auth.controller;

import com.atguigu.crowd.api.redisremote.RedisRemoteService;
import com.atguigu.crowd.common.constant.AppConst;
import com.atguigu.crowd.common.entity.AppResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年05月13日
 * @desc MemberController
 */
@RestController
@RequestMapping("auth")
public class MemberController {

    @Autowired
    private RedisRemoteService redisRemoteService;

    @PostMapping("member/send/sms")
    public AppResult<String> sendSms(@RequestParam String phoneNum) {
        // 1.检查 手机号格式,略
        if (!StringUtils.hasText(phoneNum) || phoneNum.length() != 11) {
            return AppResult.error(400, "手机号不正确");
        }

        // 2.给手机号发送验证码
        String code = String.valueOf(Math.random()).substring(2, 8);

        // 3.存入 redis ,两分钟过期 前缀
        return redisRemoteService.setRedisKeyValueRemoteWithTimeout(
                AppConst.ATTR_PHONE_CODE_PREFIX + phoneNum, code, 5, TimeUnit.MINUTES);
    }
}
