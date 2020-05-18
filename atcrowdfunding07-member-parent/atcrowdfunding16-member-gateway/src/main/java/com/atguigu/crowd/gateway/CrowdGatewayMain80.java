package com.atguigu.crowd.gateway;

import com.atguigu.crowd.common.constant.AppConst;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年05月13日
 * @desc CrowdGatewayMain80
 */
//@EnableRedisWebSession
@SpringBootApplication
public class CrowdGatewayMain80 {
    public static void main(String[] args) {
        TimeZone.setDefault(AppConst.ATTR_APP_TIMEZONE);
        SpringApplication.run(CrowdGatewayMain80.class, args);
    }
}
