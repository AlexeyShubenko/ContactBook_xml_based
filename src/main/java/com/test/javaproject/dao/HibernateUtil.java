package com.test.javaproject.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Persistence;

public class HibernateUtil {

	private static SessionFactory instance = (SessionFactory) Persistence.createEntityManagerFactory("org.hibernate.telephoneBook.jpa");;

	private HibernateUtil(){}

	public static SessionFactory getSessionFactory(){
		return instance;
	}
	
}
