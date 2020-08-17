package com.techelevator.addressbook;

import java.util.List;

public interface PhoneDao {

	Phone getById(int phoneId);
	List<Phone> getByPersonId(int personId);
	void save(Phone phone, int personId);
	void update(Phone phone);
	void delete(int phoneId);
	
	
}
