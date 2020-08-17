package com.techelevator.addressbook;

import java.sql.SQLException;
import java.util.List;

import org.junit.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcAddressDaoIntegrationTest {
	
	private static SingleConnectionDataSource datasource;
	
	private AddressDao dao;
	private JdbcTemplate jdbcTemplate;
	private int testPersonId;
	
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
		dao = new JdbcAddressDao(datasource);
		jdbcTemplate = new JdbcTemplate(datasource);
		
		// Insert a person before each test using JdbcTemplate 
		String insertPersonSql = "INSERT INTO person (person_id, first_name, last_name, date_added) VALUES (DEFAULT, 'firstName', 'lastName', null) RETURNING person_id";
		SqlRowSet rows = jdbcTemplate.queryForRowSet(insertPersonSql);
		rows.next();
		// Store the person id inserted for use in our tests
		testPersonId = rows.getInt("person_id");
	
	}
	
	@Test
	public void get_address_by_person_id() {
		// Arrange
			// Create an Address and Insert it
		Address address = getTestAddress();
		dao.save(address, testPersonId);
		
		// Act - get it by person id
		List<Address> addressList = dao.getByPersonId(testPersonId);
		
		// Assert - correct address returned
		Assert.assertEquals(1, addressList.size());
		Assert.assertEquals(address, addressList.get(0));
	}
	
	
	@Test
	public void save_address() {
		// Arrange - Create an Address
		Address newAddress = getTestAddress();
		
		// Act - save the address
		dao.save(newAddress, testPersonId);
		
		// Assert
			// The address id was set on the object 
		Assert.assertTrue( newAddress.getAddressId() > 0 );
			// Select the address and assert it exists
		Address selectedAddress = dao.getById( newAddress.getAddressId() );
		Assert.assertEquals(newAddress, selectedAddress);
		
			// Verify the Join Table was created
				// The dao method getByPersonId() would only work if the 
				// join table was populated, so it could be used to verify the join
				// join table.  Or if no such method exists - use JdbcTemplate
		String selectPersonAddressSql = "SELECT * FROM person_address WHERE person_id = ? AND address_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(selectPersonAddressSql, testPersonId, newAddress.getAddressId());
		// Don't need to test the database, so if a result is returned we know it is valid
		Assert.assertTrue( results.next() );
	}
	
	@Test
	public void update_address() {
		// Arrange - insert an address
		Address address = getTestAddress();
		dao.save(address, testPersonId);
		// Change the address
		address.setStreet("updateStreet");
		address.setLineTwo("updateLineTwo");
		address.setCity("updatedCity");
		address.setDistrict("updateDistrict");
		address.setPostalCode("updatePostalCode");
		address.setAddressType("Work");
		
		// Act - update the address with the new values
		dao.update(address);
		
		// Assert - select the address and verify the updates
		Address selectedAddress = dao.getById( address.getAddressId() );
		
		Assert.assertEquals(address, selectedAddress);
	}
	
	private Address getTestAddress() {
		Address address = new Address();
		address.setStreet("street");
		address.setLineTwo("linetwo");
		address.setCity("city");
		address.setDistrict("district");
		address.setPostalCode("postalCode");
		address.setAddressType("Home");
		return address;
	}
}
