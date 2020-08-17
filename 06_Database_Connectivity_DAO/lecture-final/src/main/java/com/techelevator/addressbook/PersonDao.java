package com.techelevator.addressbook;

import java.util.List;

public interface PersonDao {

	List<Person> list();
	Person getPersonById(int id);
	void create ( Person person );
	void delete( int personId );
}
