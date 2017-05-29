package com.test.javaproject.dto;

import com.test.javaproject.domains.Contact;
import com.test.javaproject.domains.User;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserDto implements Serializable{

	private int user_id;

	@Size(min=3, message="{User.size.login}")
	private String loginName;

	@Size(min=5, message="{User.size.password}")
	private String password;

	@Size(min=5, message="{User.size.fio}")
	private String fio;

	public UserDto(){}

	public UserDto(int user_id, String loginName, String password, String fio) {
		super();
		this.user_id = user_id;
		this.loginName = loginName;
		this.password = password;
		this.fio = fio;
	}

	public static class Builder{

		private UserDto userDto = new UserDto();

		public Builder setUserId(User user){
			userDto.setUser_id(user.getUser_id());
			return this;
		}

		public Builder setLoginName(User user){
			userDto.setLoginName(user.getLoginName());
			return this;
		}

		public Builder setPassword(User user){
			userDto.setPassword(user.getPassword());
			return this;
		}

		public Builder setFio(User user){
			userDto.setFio(user.getFio());
			return this;
		}

		public UserDto build(){
			return userDto;
		}
	}

	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
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
	public String getFio() {
		return fio;
	}
	public void setFio(String fio) {
		this.fio = fio;
	}

	@Override
	public String toString() {
		return "UserDto{" +
				"user_id=" + user_id +
				", loginName='" + loginName + '\'' +
				", password='" + password + '\'' +
				", fio='" + fio + '\'' +
				'}';
	}
}
