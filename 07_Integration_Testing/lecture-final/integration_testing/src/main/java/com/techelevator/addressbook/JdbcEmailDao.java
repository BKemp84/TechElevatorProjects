package com.techelevator.addressbook;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcEmailDao implements EmailDao {

	
	private JdbcTemplate jdbcTemplate;

	public JdbcEmailDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public Email getById(int emailId) {
		String sql = "SELECT email_id, person_id, email, email_type, type_other_description "
				+ "FROM email WHERE email_id = ?";
		
		SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, emailId);
		
		if (rows.next()) {
			return mapRowToEmail( rows );
		}
		
		return null;
	}

	@Override
	public List<Email> getByPersonId(int personId) {
		List<Email> emails = new ArrayList<Email>();
		String sql = "SELECT  email_id, person_id, email, email_type, type_other_description"
				+ " FROM email WHERE person_id = ?";
		
		SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, personId);
		
		if (rows.next()) {
			emails.add( mapRowToEmail( rows ) );
		}
		
		return emails;
	}

	@Override
	public void save(Email email, int personId) {
		String sql = "INSERT INTO email (phone_id, person_id, email, email_type, type_other_description) VALUES (DEFAULT, ?, ?, ?, ?) RETURNING email_id";
		Integer emailId = jdbcTemplate.queryForObject(sql, Integer.class, personId, email.getEmail(),  email.getEmailType(), email.getTypeOtherDescription()  );
		email.setEmailId(emailId);
		email.setPersonId(personId);
		
	}

	@Override
	public void update(Email email) {
		String sql = "UPDATE email SET emailr = ?, email_type = ?, "
				+ "type_other_description = ? WHERE email_id = ?";
		
		jdbcTemplate.update(sql, email.getEmail(), email.getEmailType(), email.getTypeOtherDescription(), email.getEmailId() ); 
		
		
	}

	@Override
	public void delete(int emailId) {
		String sql = "DELETE FROM email WHERE email_id = ?";
		jdbcTemplate.update(sql, emailId);
		
		
	}
	
	
	private Email mapRowToEmail( SqlRowSet row ) {
		Email email = new Email();
		
		email.setEmailId( row.getInt("email_id") );
		email.setPersonId( row.getInt("person_id") );
		email.setEmail( row.getString("email") );
		email.setEmailType( row.getString("email_type") );
		email.setTypeOtherDescription( row.getString("type_other_description") );
		
		return email;
	}

}
