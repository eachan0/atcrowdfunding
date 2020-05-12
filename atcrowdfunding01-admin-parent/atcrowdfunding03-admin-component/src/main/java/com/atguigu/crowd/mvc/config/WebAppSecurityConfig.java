package com.atguigu.crowd.mvc.config;

import com.atguigu.crowd.util.constant.CrowConst;
import com.atguigu.crowd.util.constant.SecurityConst;
import com.atguigu.crowd.util.enums.ExceptionEnum;
import com.atguigu.crowd.util.exception.AppException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年05月11日
 * @desc WebAppSecurityConfig
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebAppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CrowdUserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(CrowConst.ATTR_SECURITY_IGNORE)
                .permitAll()
                .antMatchers("/admin/get/page.html")
//                .hasRole("经理")
                .access("hasRole('经理') or hasAuthority('user:get')")
                .anyRequest()
                .authenticated()
                .and()
                .exceptionHandling()
                .accessDeniedHandler((request, response, accessDeniedException) -> {
                    request.setAttribute(CrowConst.ATTR_EXCEPTION, new AppException(ExceptionEnum.ACCESS_DENIED));
                    request.getRequestDispatcher(SecurityConst.ATTR_ERROR_PAGE).forward(request, response);
                })
                .and()
                .csrf().disable()
                .formLogin()
                .loginPage(SecurityConst.ATTR_LOGIN_PAGE)
                .loginProcessingUrl(SecurityConst.ATTR_LOGIN_URL)
                .usernameParameter(SecurityConst.ATTR_LOGIN_NAME)
                .passwordParameter(SecurityConst.ATTR_LOGIN_PSWD)
                .defaultSuccessUrl(SecurityConst.ATTR_LOGIN_SUCCESS_URL)
                .and()
                .logout()
                .logoutUrl(SecurityConst.ATTR_LOGOUT_URL)
                .logoutSuccessUrl(SecurityConst.ATTR_LOGOUT_SUCCESS_URL)
        ;
    }
}
