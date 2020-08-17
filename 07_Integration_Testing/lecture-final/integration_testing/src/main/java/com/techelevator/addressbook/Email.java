package com.techelevator.addressbook;

public class Email {
	
	private int emailId;
	private int personId;
	private String email;
	private String emailType;
	private String typeOtherDescription;
	
	public int getEmailId() {
		return emailId;
	}
	public void setEmailId(int email_id) {
		this.emailId = email_id;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int person_id) {
		this.personId = person_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmailType() {
		return emailType;
	}
	public void setEmailType(String emailType) {
		this.emailType = emailType;
	}
	public String getTypeOtherDescription() {
		return typeOtherDescription;
	}
	public void setTypeOtherDescription(String typeOtherDescription) {
		this.typeOtherDescription = typeOtherDescription;
	}
	
	@Override
	public String toString() {
		return "Email [email_id=" + emailId + ", person_id=" + personId + ", email=" + email + ", emailType="
				+ emailType + ", typeOtherDescription=" + typeOtherDescription + "]";
	}
	
	
}
