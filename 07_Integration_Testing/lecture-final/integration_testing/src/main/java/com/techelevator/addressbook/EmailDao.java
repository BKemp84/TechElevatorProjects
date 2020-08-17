package com.techelevator.addressbook;

import java.util.List;

public interface EmailDao {
	
	Email getById(int emailId);
	List<Email> getByPersonId(int personId);
	void save(Email email, int personId);
	void update(Email email);
	void delete(int emailId);
	
}
