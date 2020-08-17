package com.techelevator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.addressbook.*;

public class AddressDemo {

	public static void main(String[] args) {
		
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/addressbook");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		
		PersonDao personDao = new JdbcPersonDao(dataSource);
		AddressDao addressDao = new JdbcAddressDao(dataSource);
		
		Person person = new Person();
		person.setFirstName("Dave");
		person.setLastName("Smith");
		person.setDateAdded( LocalDate.parse("1980-10-22", DateTimeFormatter.ofPattern("yyyy-MM-dd")) );
		
		personDao.save( person );
		
		System.out.println(person);
		
		Address address = new Address();
		address.setStreet("123 Street");
		address.setCity("Columbus");
		address.setDistrict("Ohio");
		address.setPostalCode("43201");
		address.setAddressType("Home");
		
		addressDao.save(address, person.getPersonId());
		
		List<Address> addresses = addressDao.getByPersonId( person.getPersonId() );
		
		System.out.println(addresses);
		
	}

}
