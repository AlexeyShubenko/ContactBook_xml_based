package com.test.javaproject.dto;

import com.test.javaproject.domains.Contact;

import javax.validation.constraints.Size;
import java.io.Serializable;

public class ContactDto implements Serializable{

	private int contact_id;

	@Size(min=4, message="{contact.size.name}")
	private String firstName;

	@Size(min=4, message="{contact.size.name}")
	private String lastName;

	@Size(min=4, message="{contact.size.name}")
	private String middleName;

	@Size(min=15, max=15, message="{contact.size.phNumber}")
	private String mobPhoneNumber;

	private String homePhoneNumber;

	private String address;

	private String email;

	public ContactDto(){}

	public ContactDto(int contact_id, String firstname, String lastname, String middlename, String mobPhoneNumber,
                      String homePhoneNumber, String address, String email) {
		super();
		this.contact_id = contact_id;
		this.firstName = firstname;
		this.lastName = lastname;
		this.middleName = middlename;
		this.mobPhoneNumber = mobPhoneNumber;
		this.homePhoneNumber = homePhoneNumber;
		this.address = address;
		this.email = email;
	}

	public static class Builder{

		private ContactDto contactDto = new ContactDto();

		public Builder setContactId(Contact contact){
			contactDto.setContact_id(contact.getContact_id());
			return this;
		}

		public Builder setFirstName(Contact contact){
			contactDto.setFirstName(contact.getFirstName());
			return this;
		}

		public Builder setLastName(Contact contact){
			contactDto.setLastName(contact.getLastName());
			return this;
		}

		public Builder setMiddleName(Contact contact){
			contactDto.setMiddleName(contact.getMiddleName());
			return this;
		}

		public Builder setMobPhoneNumber(Contact contact){
			contactDto.setMobPhoneNumber(contact.getMobPhoneNumber());
			return this;
		}

		public Builder setHomePhoneNumber(Contact contact){
			contactDto.setHomePhoneNumber(contact.getHomePhoneNumber());
			return this;
		}

		public Builder setEmail(Contact contact){
			contactDto.setAddress(contact.getAddress());
			return this;
		}

		public Builder setAddress(Contact contact){
			contactDto.setEmail(contact.getEmail());
			return this;
		}
		public ContactDto build(){
			return  contactDto;
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

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
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

	@Override
	public String toString() {
		return "ContactDto{" +
				"contact_id=" + contact_id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", middleName='" + middleName + '\'' +
				", mobPhoneNumber='" + mobPhoneNumber + '\'' +
				", homePhoneNumber='" + homePhoneNumber + '\'' +
				", address='" + address + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}
