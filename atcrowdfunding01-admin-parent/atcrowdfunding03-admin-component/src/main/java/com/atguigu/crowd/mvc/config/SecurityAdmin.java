package com.atguigu.crowd.mvc.config;

import com.atguigu.crowd.entity.AdminEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年05月12日
 * @desc SecurityAdmin
 */
public class SecurityAdmin extends User {
    private static final long serialVersionUID = -2670026491775338046L;

    private AdminEntity originalAdmin;

    public SecurityAdmin(AdminEntity originalAdmin, Collection<? extends GrantedAuthority> authorities) {
        super(originalAdmin.getUserName(), originalAdmin.getUserPswd(), authorities);
        originalAdmin.setUserPswd(null);
        this.originalAdmin = originalAdmin;
    }

    public AdminEntity getOriginalAdmin() {
        return originalAdmin;
    }

    public void setOriginalAdmin(AdminEntity originalAdmin) {
        this.originalAdmin = originalAdmin;
    }
    public static SecurityAdmin build(AdminEntity originalAdmin, Collection<? extends GrantedAuthority> authorities){
        return new SecurityAdmin(originalAdmin,authorities);
    }
}
