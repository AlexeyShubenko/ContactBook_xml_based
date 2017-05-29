package com.test.javaproject.domains;

import com.test.javaproject.dto.UserDto;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="user")
public class User implements Serializable{

	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int user_id;
	
	@Column(name="loginName", nullable=false)
	private String loginName;
	
	@Column(name="password", nullable=false)
	private String password;
	
	@Column(name="fio", nullable=false)
	private String fio;
	
	@OneToMany(mappedBy="user")
	private List<Contact> contacts = new ArrayList<Contact>();
	
	public User(){}
	
	public User(int user_id, String loginName, String password, String fio) {
		super();
		this.user_id = user_id;
		this.loginName = loginName;
		this.password = password;
		this.fio = fio;
	}

	public static class Builder{

		private User user = new User();

		public User.Builder setUserId(UserDto userDto){
			user.setUser_id(userDto.getUser_id());
			return this;
		}

		public User.Builder setLoginName(UserDto userDto){
			user.setLoginName(userDto.getLoginName());
			return this;
		}

		public User.Builder setPassword(UserDto userDto){
			user.setPassword(userDto.getPassword());
			return this;
		}

		public User.Builder setFio(UserDto userDto){
			user.setFio(userDto.getFio());
			return this;
		}

		public User build(){
			return user;
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
	public List<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
		
}
