package com.test.javaproject.domains;

import javax.validation.constraints.Size;

public class LoginTempObject {

	@Size(min = 3)
	private String loginName;
	@Size(min = 3)
	private String password;
	
	public LoginTempObject(){}
	
	public LoginTempObject(String loginName, String password) {
		super();
		this.loginName = loginName;
		this.password = password;
	}
	
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
		
}
