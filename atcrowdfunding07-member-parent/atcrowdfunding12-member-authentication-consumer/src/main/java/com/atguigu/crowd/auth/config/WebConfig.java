package com.atguigu.crowd.auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年05月13日
 * @desc WebConfig
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/auth/member/reg/page").setViewName("member-reg");
        registry.addViewController("/auth/member/login/page").setViewName("member-login");
        registry.addViewController("/auth/member/center/page").setViewName("member-center");
    }
}
