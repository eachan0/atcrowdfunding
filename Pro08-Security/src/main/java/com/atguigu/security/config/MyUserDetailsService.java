package com.atguigu.security.config;

import java.util.ArrayList;
import java.util.List;

import com.atguigu.security.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// 总目标：根据表单提交的用户名查询User对象，并装配角色、权限等信息
	@Override
	public UserDetails loadUserByUsername(

			// 表单提交的用户名
			String username

		) throws UsernameNotFoundException {

		// 1.从数据库查询Admin对象
		String sql = "SELECT id,login_acct,user_pswd,user_name,email FROM t_admin WHERE login_acct=?";

		List<Admin> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Admin.class), username);

		Admin admin = list.get(0);

		// 2.给Admin设置角色权限信息
		List<GrantedAuthority> authorities = new ArrayList<>();

		authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		authorities.add(new SimpleGrantedAuthority("UPDATE"));

		// 3.把admin对象和authorities封装到UserDetails中

		String userpswd = admin.getUser_pswd();

		return new User(username, userpswd, authorities);
	}

}
