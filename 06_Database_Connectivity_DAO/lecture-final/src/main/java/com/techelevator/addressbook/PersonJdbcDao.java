package com.techelevator.addressbook;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class PersonJdbcDao implements PersonDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public PersonJdbcDao(DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}

	@Override
	public List<Person> list() {
		
		List<Person> persons = new ArrayList<Person>();
		
		String selectSql = "SELECT person_id, first_name, last_name, date_added FROM person";
		
		SqlRowSet rows = jdbcTemplate.queryForRowSet(selectSql);
		
		while( rows.next() ) {
			Person person = mapRowToPerson( rows );
			persons.add( person );
		}
		
		
		return persons;
	}

	@Override
	public Person getPersonById(int id) {
		Person person = null;
		
		String selectPersonSql = "SELECT person_id, first_name, last_name, date_added FROM person WHERE person_id = ?";
		SqlRowSet rows = jdbcTemplate.queryForRowSet(selectPersonSql, id);
		
		if ( rows.next() ) {
			person = mapRowToPerson( rows );
		}
		
		return person;
	}
	
	
	@Override
	public void create(Person person) {
		String insertSql = "INSERT INTO person (person_id, first_name, last_name, date_added) VALUES (DEFAULT, ?, ?, ?) RETURNING person_id";
		
		SqlRowSet rows = jdbcTemplate.queryForRowSet(insertSql, person.getFirstName(), person.getLastName(), person.getDateAdded());
		
		rows.next();
		int id = rows.getInt("person_id");
		
		person.setPersonId( id );
		
	}
	
	
	private Person mapRowToPerson( SqlRowSet row ) {
		Person person = new Person();
		
		person.setPersonId( row.getInt("person_id") );
		person.setFirstName( row.getString("first_name") );
		person.setLastName( row.getString("last_name") );
		
		if ( row.getDate("date_added") != null) {
			person.setDateAdded( row.getDate("date_added").toLocalDate() );
		}
		
		return person;
	}

	@Override
	public void delete(int personId) {
		String deleteSql = "DELETE FROM person WHERE person_id = ?";
		
		jdbcTemplate.update(deleteSql, personId);
		
	}


	
	
}
