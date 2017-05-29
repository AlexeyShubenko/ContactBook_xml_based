package com.test.javaproject.dao;


import com.test.javaproject.domains.Contact;
import com.test.javaproject.domains.SearchObject;
import com.test.javaproject.domains.User;
import com.test.javaproject.dto.ContactDto;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class ContactService implements ContactDAO {

	private SearchObject search;
	private EntityManager manager;

	@Autowired
	public ContactService(SearchObject search){
		this.search = search;
	}

	@Override
	public List<ContactDto> getContactList(int user_id) {
		List<Contact> contacts;
		List<ContactDto> contactsDto = new ArrayList<>();
		manager = HibernateUtil.getSessionFactory().createEntityManager();
		try{
			manager.getTransaction().begin();
			contacts = manager.createQuery("from Contact c where c.user.user_id = :user_id",Contact.class)
				.setParameter("user_id", user_id)
				.getResultList();
			for (Contact c:contacts){
				System.out.println(c.toString());
				ContactDto contactDto = new ContactDto.Builder()
						.setContactId(c)
						.setAddress(c)
						.setEmail(c)
						.setFirstName(c)
						.setHomePhoneNumber(c)
						.setLastName(c)
						.setMiddleName(c)
						.setMobPhoneNumber(c)
						.build();
				contactsDto.add(contactDto);
			}
			manager.getTransaction().commit();
		}catch(Exception e){
				manager.getTransaction().rollback();

		}finally{
			manager.close();
		}
		return contactsDto;
	}

	@Override
	public void saveContact(int user_id, ContactDto contactDto) {
		manager = HibernateUtil.getSessionFactory().createEntityManager();
		User readUser;
		Contact contact = new Contact.Builder()
				.setFirstName(contactDto)
				.setLastName(contactDto)
				.setMiddleName(contactDto)
				.setHomePhoneNumber(contactDto)
				.setMobPhoneNumber(contactDto)
				.setAddress(contactDto)
				.setEmail(contactDto)
				.build();
		try{
			manager.getTransaction().begin();
			readUser = manager.createQuery("from User u where u.id =:user_id",User.class)
					.setParameter("user_id",user_id)
					.getSingleResult();
			contact.setUser(readUser);
			manager.persist(contact);
			manager.getTransaction().commit();
		}catch(Exception e){
				manager.getTransaction().rollback();
		}finally{
			manager.close();
		}
	}
	
	@Override
	public void editContact(ContactDto contactDto) {
		manager = HibernateUtil.getSessionFactory().createEntityManager();
		try{
			manager.getTransaction().begin();
			Contact oldCont = manager.createQuery("from Contact where contact_id=:contact_id",Contact.class)
				.setParameter("contact_id", contactDto.getContact_id())
			 	.getSingleResult();
			oldCont.setFirstName(contactDto.getFirstName());
			oldCont.setLastName(contactDto.getLastName());
			oldCont.setMiddleName(contactDto.getMiddleName());
			oldCont.setMobPhoneNumber(contactDto.getMobPhoneNumber());
			oldCont.setHomePhoneNumber(contactDto.getHomePhoneNumber());
			oldCont.setAddress(contactDto.getAddress());
			oldCont.setEmail(contactDto.getEmail());
			manager.getTransaction().commit();
		}catch(Exception e){
			manager.getTransaction().rollback();
		}finally{
			manager.close();
		}
	}
	
	@Override
	public ContactDto getContactById(int contact_id) {
		Contact contact;
		ContactDto contactDto = null;
		manager = HibernateUtil.getSessionFactory().createEntityManager();
		try{
			manager.getTransaction().begin();
			contact = manager.createQuery("from Contact where contact_id=:contact_id",Contact.class)
				.setParameter("contact_id", contact_id)
				.getSingleResult();
			contactDto = new ContactDto.Builder()
					.setContactId(contact)
					.setAddress(contact)
					.setEmail(contact)
					.setFirstName(contact)
					.setHomePhoneNumber(contact)
					.setLastName(contact)
					.setMiddleName(contact)
					.setMobPhoneNumber(contact)
					.build();
			manager.getTransaction().commit();
		}catch(Exception e){
			manager.getTransaction().rollback();
		}finally{
			manager.close();
		}
		return contactDto;
	}
	
	@Override
	public void deleteContact(int contact_id) {
		Contact contact;
		manager = HibernateUtil.getSessionFactory().createEntityManager();
		try{
			manager.getTransaction().begin();
			contact = manager.createQuery("from Contact where contact_id=:contact_id",Contact.class)
					.setParameter("contact_id", contact_id)
					.getSingleResult();;
			manager.remove(contact);
			manager.getTransaction().commit();
		}catch(Exception e){
			manager.getTransaction().rollback();
		}finally{
			manager.close();
		}
	}

	@Override
	public List<ContactDto> getContactsByParam(SearchObject s, int user_id) {
//		List<Contact> contacts;
		List<ContactDto> contactsDto = getContactList(user_id);
//		manager = HibernateUtil.getSessionFactory().createEntityManager();
//		try{
//			manager.getTransaction().begin();
//			contacts = manager.createQuery("from Contact where user.id = :user_id",Contact.class)
//				.setParameter("user_id", user_id)
//				.getResultList();
//			for (Contact c:contacts){
//				ContactDto contactDto = new ContactDto.Builder()
//						.setContactId(c)
//						.setAddress(c)
//						.setEmail(c)
//						.setFirstName(c)
//						.setHomePhoneNumber(c)
//						.setLastName(c)
//						.setMiddleName(c)
//						.setMobPhoneNumber(c)
//						.build();
//				contactsDto.add(contactDto);
//			}
//			manager.getTransaction().commit();
//		}catch(Exception e){
//			manager.getTransaction().rollback();
//		}finally{
//			manager.close();
//		}
		///true - search by name, false - search by number
		if(s.isFlag()){
			return search.searchByName(s, contactsDto);
		}else return search.searchByNumber(s, contactsDto);
	}
}
