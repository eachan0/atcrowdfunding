package com.atguigu.crowd.project;

import com.atguigu.crowd.common.constant.AppConst;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.TimeZone;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年05月15日
 * @desc CrowdProjectMain500
 */
@EnableFeignClients(basePackages = "com.atguigu.crowd.api")
@EnableDiscoveryClient
@SpringBootApplication
public class CrowdProjectMain5000 {
    public static void main(String[] args) {
        TimeZone.setDefault(AppConst.ATTR_APP_TIMEZONE);
        SpringApplication.run(CrowdProjectMain5000.class, args);
    }
}
