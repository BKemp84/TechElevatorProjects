package com.techelevator.addressbook;

import java.util.List;

public interface PersonDao {

	List<Person> list();
	Person getById(int personId);
	void save(Person person);
	void update(Person person);
	void delete(int personId);
}
