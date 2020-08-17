package com.techelevator.addressbook;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcPhoneDao implements PhoneDao {

	private JdbcTemplate jdbcTemplate;

	public JdbcPhoneDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public Phone getById(int phoneId) {
		String sql = "SELECT phone_id, person_id, phone_number, extension, phone_type, type_other_description FROM phone WHERE phone_id = ?";
		
		SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, phoneId);
		
		if (rows.next()) {
			return mapRowToPhone( rows );
		}
		
		return null;
	}
	

	@Override
	public List<Phone> getByPersonId(int personId) {
		
		List<Phone> phones = new ArrayList<Phone>();
		String sql = "SELECT phone_id, person_id, phone_number, extension, phone_type, type_other_description FROM phone WHERE person_id = ?";
		
		SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, personId);
		
		if (rows.next()) {
			phones.add( mapRowToPhone( rows ) );
		}
		
		return phones;
	}

	@Override
	public void save(Phone phone, int personId) {
		String sql = "INSERT INTO phone (phone_id, person_id, phone_number, extension, phone_type, type_other_description) VALUES (DEFAULT, ?, ?, ?, ?, ?) RETURNING phone_id";
		Integer phoneId = jdbcTemplate.queryForObject(sql, Integer.class, personId, phone.getPhoneNumber(), phone.getExtension(), phone.getPhoneType(), phone.getTypeOtherDescription()  );
		phone.setPhoneId(phoneId);
		phone.setPersonId(personId);
	}

	@Override
	public void update(Phone phone) {
		
		String sql = "UPDATE phone SET phone_number = ?, extension = ?, phone_type = ?, "
				+ "type_other_description = ? WHERE phone_id = ?";
		
		jdbcTemplate.update(sql, phone.getPhoneNumber(), phone.getExtension(), phone.getPhoneType(), phone.getTypeOtherDescription(), phone.getPhoneId() ); 
		
	}

	@Override
	public void delete(int phoneId) {
		String sql = "DELETE FROM phone WHERE phone_id = ?";
		jdbcTemplate.update(sql, phoneId);
		
	}

	private Phone mapRowToPhone( SqlRowSet row ) {
		Phone phone = new Phone();
		
		phone.setPhoneId( row.getInt("phone_id") );
		phone.setPersonId( row.getInt("person_id") );
		phone.setPhoneNumber( row.getString("phone_number") );
		phone.setExtension( row.getString("extension") );
		phone.setPhoneType( row.getString("phone_type") );
		phone.setTypeOtherDescription( row.getString("type_other_description") );
		
		return phone;
	}
	
}
