package com.techelevator.addressbook;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.sql.DataSource;

import org.junit.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcPersonDaoIntegrationTest {

	private static SingleConnectionDataSource datasource;
	
	private PersonDao dao;
	private JdbcTemplate jdbcTemplate;
	
	
	@BeforeClass
	public static void setupDataSource() {
		// Create Single Connection Data Source
		datasource = new SingleConnectionDataSource();
		datasource.setUrl("jdbc:postgresql://localhost:5432/addressbook");
		datasource.setUsername("postgres");
		datasource.setPassword("postgres1");
		
		// Turn AutoCommit off so we can rollback the transactions
		datasource.setAutoCommit( false );
	}
	
	@AfterClass
	public static void destroyDataSource() {
		// After all tests are run cleanup the data source and connection to the database
		datasource.destroy();
	}
	
	@After
	public void rollbackTransaction() throws SQLException {
		// Rollback the transaction after each test completes
		datasource.getConnection().rollback();
	}
	
	
	@Before
	public void setupTest() {
		// Create the DAO and JdbcTemplate using the same connection so they share the transaction
		dao = new JdbcPersonDao(datasource);
		jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	@Test
	public void get_person_by_person_id() {
		// Arrange (Setup)
			// Create a person
			Person person = getTestPerson();
			// Insert it into the database
		dao.save(person);
		
		// Act (Test)
			// Select the person by the id
		Person selectedPerson = dao.getById( person.getPersonId() );
		
		// Assert (Verify)
			// Verify its the same data
		Assert.assertEquals(person, selectedPerson);
	}
	
	@Test
	public void get_list_of_persons_using_original_table_size() {
		// Arrange (Setup)
			// Use list() to get all persons and store how many returned
		List<Person> persons = dao.list();
		int originalCount = persons.size();
		
			// Insert a new person
				// Create Person and insert
		Person person = getTestPerson();
		dao.save( person );
		
		// Act (Test)
		persons = dao.list();
		
		// Assert (Verify) - did the size increase by 1
		Assert.assertEquals(originalCount + 1, persons.size());
	}
	
	@Test
	public void get_list_using_table_truncation() {
		// Arrange
			// Truncate all data from the table
		truncatePersonTable();
			// Insert a few records
		dao.save( getTestPerson() );
		dao.save( getTestPerson() );
		
		// Act
		List<Person> persons = dao.list();
		
		// Assert - verify the correct number returned
		Assert.assertEquals(2, persons.size());
		
	}
	
	@Test
	public void save_person() {
		// Arrange - create a person
		Person person = getTestPerson();
		
		// Act - save person with dao
		dao.save( person );
		// Assert
			// Assert the id set on the person object
		Assert.assertTrue( person.getPersonId() > 0 );  // At this point, reasonable sure insert worked
		
			// Select person 
		Person selectedPerson = dao.getById( person.getPersonId() );
			// Assert the same data
		Assert.assertEquals(person, selectedPerson);
	}
	
	/*
	 * This test can use the DAO, but for demonstration only will use JdbcTemplate
	 */
	@Test
	public void update_person() {
		// Arrange 
			// Create and insert a person
		Person person = getTestPerson();
			// Insert 
		String insertSql = "INSERT INTO person (person_id, first_name, last_name, date_added) VALUES (DEFAULT, ?, ?, ?) "
				+ "RETURNING person_id";
		// Date.valueOf() will convert LocalDate to a Sql Friendly Date Object
		SqlRowSet result = jdbcTemplate.queryForRowSet( insertSql, person.getFirstName(), person.getLastName(), 
				Date.valueOf(person.getDateAdded()));
		result.next();
		person.setPersonId( result.getInt("person_id") );
		
			// Update the values
		person.setFirstName("updatedFirstName");
		person.setLastName("updatedLastName");
		person.setDateAdded( LocalDate.now() );
		
		// Act 
		dao.update( person );
		
		// Assert
			// Select the person and make sure the update changed the field
		String selectPersonSql = "SELECT * FROM person WHERE person_id = ?";
		SqlRowSet rows = jdbcTemplate.queryForRowSet(selectPersonSql, person.getPersonId() );
		
		// Assert data returned
		Assert.assertTrue( rows.next() ); 
		// Assert on the values returned
		Assert.assertEquals( person.getFirstName(), rows.getString("first_name") );
		Assert.assertEquals( person.getLastName(), rows.getString("last_name") );
		Assert.assertEquals( person.getDateAdded(), rows.getDate("date_added").toLocalDate() );
		
		// Assert next() is false - meaning there is no more data
		Assert.assertFalse( rows.next() );
	}
	
	@Test
	public void delete_person() {
		// Arrange 
			// Create and Insert a Person
		Person person = getTestPerson();
		dao.save( person );
		
		// Act - delete using the DAO
		dao.delete( person.getPersonId() );
		
		// Assert
			// Select and verify no results found
		Person selectedPerson = dao.getById( person.getPersonId() );
		Assert.assertNull( selectedPerson );
	}
	
	
	private void truncatePersonTable() {
		String truncateSql = "TRUNCATE person CASCADE";
		jdbcTemplate.update(truncateSql);
	}
	
	
	private Person getTestPerson() {
		Person person = new Person();
		person.setFirstName("testFirstname");
		person.setLastName("testLastname");
		person.setDateAdded( LocalDate.parse("1980-10-22", DateTimeFormatter.ofPattern("yyyy-MM-dd")) );
		return person;
	}
}
