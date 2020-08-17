package com.techelevator.addressbook;

public class Phone {

	private int phoneId;
	private int personId;
	private String phoneNumber;
	private String extension;
	private String phoneType;
	private String typeOtherDescription;
	
	public int getPhoneId() {
		return phoneId;
	}
	public void setPhoneId(int phone_id) {
		this.phoneId = phone_id;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int person_id) {
		this.personId = person_id;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	public String getPhoneType() {
		return phoneType;
	}
	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}
	public String getTypeOtherDescription() {
		return typeOtherDescription;
	}
	public void setTypeOtherDescription(String typeOtherDescription) {
		this.typeOtherDescription = typeOtherDescription;
	}
	
	@Override
	public String toString() {
		return "Phone [phone_id=" + phoneId + ", person_id=" + personId + ", phoneNumber=" + phoneNumber
				+ ", extension=" + extension + ", phoneType=" + phoneType + ", typeOtherDescription="
				+ typeOtherDescription + "]";
	}
	
}
