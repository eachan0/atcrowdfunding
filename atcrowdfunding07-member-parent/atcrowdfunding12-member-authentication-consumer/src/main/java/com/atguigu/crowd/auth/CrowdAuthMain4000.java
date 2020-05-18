package com.atguigu.crowd.auth;

import com.atguigu.crowd.common.constant.AppConst;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

import java.util.TimeZone;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年05月13日
 * @desc CrowdAuthMain4000
 */
@EnableRedisHttpSession
@EnableFeignClients(basePackages = "com.atguigu.crowd.api")
@EnableDiscoveryClient
@SpringBootApplication
public class CrowdAuthMain4000 {
    public static void main(String[] args) {
        TimeZone.setDefault(AppConst.ATTR_APP_TIMEZONE);
        SpringApplication.run(CrowdAuthMain4000.class, args);
    }
}
