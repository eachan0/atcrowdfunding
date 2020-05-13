package com.atguigu.crowd.mysql;

import com.atguigu.crowd.common.constant.AppConst;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.TimeZone;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年05月13日
 * @desc CrowdMysqlMain2000
 */
@EnableDiscoveryClient
@SpringBootApplication
public class CrowdMysqlMain2000 {
    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone(AppConst.ATTR_APP_TIMEZONE));
        SpringApplication.run(CrowdMysqlMain2000.class, args);
    }
}
