package com.atguigu.security.entity;

public class Admin {

	private Integer id;
	private String login_acct;
	private String user_pswd;
	private String user_name;
	private String email;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin_acct() {
		return login_acct;
	}

	public void setLogin_acct(String login_acct) {
		this.login_acct = login_acct;
	}

	public String getUser_pswd() {
		return user_pswd;
	}

	public void setUser_pswd(String user_pswd) {
		this.user_pswd = user_pswd;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
