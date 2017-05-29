package com.test.javaproject.dao;

import com.test.javaproject.domains.LoginTempObject;
import com.test.javaproject.domains.User;
import com.test.javaproject.dto.UserDto;

public interface UserDAO {

	UserDto getUserByLoginObject(LoginTempObject loginObject);
//	boolean checkExistingUser(LoginTempObject loginObject);
	boolean checkExistingUser(UserDto userDto);
	void saveUser(UserDto userDto);
	
}
