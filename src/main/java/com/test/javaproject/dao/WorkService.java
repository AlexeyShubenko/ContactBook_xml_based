package com.test.javaproject.dao;

import com.test.javaproject.domains.*;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class WorkService {

    private UserService userService;
    private ContactService contactService;

	@Autowired
	public WorkService(UserService userService, ContactService contactService){
		this.userService = userService;
		this.contactService = contactService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public ContactService getContactService() {
		return contactService;
	}

	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}

}
