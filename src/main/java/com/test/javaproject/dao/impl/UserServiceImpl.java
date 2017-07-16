package com.test.javaproject.dao.impl;

import com.test.javaproject.dao.HibernateUtil;
import com.test.javaproject.dao.UserService;
import com.test.javaproject.domains.LoginTempObject;
import com.test.javaproject.domains.User;
import com.test.javaproject.dto.UserDto;
import com.test.javaproject.exceptions.UserNotFindException;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.Objects;

public class UserServiceImpl implements UserService {

	private EntityManager manager;

	@Override
	public void saveUser(UserDto userDto) {
		manager = HibernateUtil.getSessionFactory().createEntityManager();
		User user = new User.Builder().setFio(userDto)
				.setLoginName(userDto)
				.setPassword(userDto)
				.build();
		try{
			manager.getTransaction().begin();
			manager.persist(user);
			manager.getTransaction().commit();
			}catch(Exception e){
				manager.getTransaction().rollback();
			}finally {
				manager.close();
			}
	}
	
	@Override
	public UserDto getUserByLoginObject(LoginTempObject loginObject) {
		manager = HibernateUtil.getSessionFactory().createEntityManager();
		User user;
		UserDto userDto=null;
		try{
			manager.getTransaction().begin();
			user = manager.createQuery("from User where loginName=:loginName ", User.class)
								.setParameter("loginName", loginObject.getLoginName())
								.getSingleResult();
			userDto = new UserDto.Builder()
					.setUserId(user)
					.setFio(user)
					.setLoginName(user)
					.setPassword(user)
					.build();
			manager.getTransaction().commit();
		}catch (NoResultException noResult){
				throw new UserNotFindException("Пользователь не найден");
		}catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			manager.close();
		}

		return userDto;
	}
	
	@Override
	public boolean checkExistingUser(UserDto userDto) {
		User userTemp = null;
		User user = new User.Builder().setFio(userDto)
				.setLoginName(userDto)
				.setPassword(userDto)
				.build();
		manager = HibernateUtil.getSessionFactory().createEntityManager();
		try{
			manager.getTransaction().begin();
			userTemp = manager.createQuery("select u from User u where u.loginName=:loginName",User.class)
					.setParameter("loginName", user.getLoginName())
					.getSingleResult();
			manager.getTransaction().commit();
		}catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			manager.close();
		}
		return Objects.nonNull(userTemp);
	}

}
