package com.test.javaproject.domains;

import com.test.javaproject.dto.ContactDto;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name="contact")
public class Contact implements Serializable{

	@Id
	@Column(name="contact_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int contact_id;

	@Column(name="firstname", nullable=false)
	private String firstName;

	@Column(name="lastname", nullable=false)
	private String lastName;

	@Column(name="middlename", nullable=false)
	private String middleName;

	@Column(name="mobPhoneNumber", nullable=false)
	private String mobPhoneNumber;
	
	@Column(name="homePhoneNumber")
	private String homePhoneNumber;
	
	@Column(name="address")
	private String address;

	@Column(name="email")
	private String email;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	public Contact(){}
	
	public Contact(int contact_id, String firstName, String lastName, String middleName, String mobPhoneNumber,
				   String homePhoneNumber, String address, String email) {
		super();
		this.contact_id = contact_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.mobPhoneNumber = mobPhoneNumber;
		this.homePhoneNumber = homePhoneNumber;
		this.address = address;
		this.email = email;
	}

	public static class Builder{

		private Contact contact = new Contact();

		public Builder setContactId(ContactDto contactDto){
			contactDto.setContact_id(contactDto.getContact_id());
			return this;
		}

		public Builder setFirstName(ContactDto contactDto){
			contact.setFirstName(contactDto.getFirstName());
			return this;
		}

		public Builder setLastName(ContactDto contactDto){
			contact.setLastName(contactDto.getFirstName());
			return this;
		}

		public Builder setMiddleName(ContactDto contactDto){
			contact.setMiddleName(contactDto.getMiddleName());
			return this;
		}

		public Builder setMobPhoneNumber(ContactDto contactDto){
			contact.setMobPhoneNumber(contactDto.getMobPhoneNumber());
			return this;
		}

		public Builder setHomePhoneNumber(ContactDto contactDto){
			contact.setHomePhoneNumber(contactDto.getHomePhoneNumber());
			return this;
		}

		public Builder setEmail(ContactDto contactDto){
			contact.setAddress(contactDto.getAddress());
			return this;
		}

		public Builder setAddress(ContactDto contactDto){
			contact.setEmail(contactDto.getEmail());
			return this;
		}

		public Contact build(){
			return contact;
		}

	}

	public int getContact_id() {
		return contact_id;
	}	
	public void setContact_id(int contact_id) {
		this.contact_id = contact_id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstname) {
		this.firstName = firstname;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastname) {
		this.lastName = lastname;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middlename) {
		this.middleName = middlename;
	}
	public String getMobPhoneNumber() {
		return mobPhoneNumber;
	}
	public void setMobPhoneNumber(String mobPhoneNumber) {
		this.mobPhoneNumber = mobPhoneNumber;
	}
	public String getHomePhoneNumber() {
		return homePhoneNumber;
	}
	public void setHomePhoneNumber(String homePhoneNumber) {
		this.homePhoneNumber = homePhoneNumber;
	}	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Contact{" +
				"contact_id=" + contact_id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", middleName='" + middleName + '\'' +
				", mobPhoneNumber='" + mobPhoneNumber + '\'' +
				", homePhoneNumber='" + homePhoneNumber + '\'' +
				", address='" + address + '\'' +
				", email='" + email + '\'' +
				", user=" + user +
				'}';
	}
}
