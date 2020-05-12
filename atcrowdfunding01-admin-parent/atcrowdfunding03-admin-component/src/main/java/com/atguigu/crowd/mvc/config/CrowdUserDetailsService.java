package com.atguigu.crowd.mvc.config;

import com.atguigu.crowd.entity.AdminEntity;
import com.atguigu.crowd.entity.RoleEntity;
import com.atguigu.crowd.service.AdminService;
import com.atguigu.crowd.service.AuthService;
import com.atguigu.crowd.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年05月12日
 * @desc CrowdUserDetailsService
 */
@Component
public class CrowdUserDetailsService implements UserDetailsService {

    @Autowired
    private AdminService adminService;

    @Autowired
    private AuthService authService;

    @Autowired
    private RoleService roleService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AdminEntity entity = adminService.getByUsername(username);

        if (entity == null) {
            throw new UsernameNotFoundException("用户名或者密码错误");
        }

        List<RoleEntity> roleList = roleService.assignRole(entity.getId());
        List<String> roles = roleList.stream().map(RoleEntity::getName).distinct().collect(Collectors.toList());

        List<String> auths = authService.getAuthNameByAdminId(entity.getId());
        auths = auths.stream().filter(StringUtils::hasText).distinct().collect(Collectors.toList());
        List<GrantedAuthority> authorities = new ArrayList<>(roles.size() + auths.size());

        roles.forEach(x->authorities.add(new SimpleGrantedAuthority("ROLE_" + x)));
        auths.forEach(x->authorities.add(new SimpleGrantedAuthority(x)));
        return SecurityAdmin.build(entity,authorities);
    }
}
