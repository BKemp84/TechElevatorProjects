package com.techelevator.tenmo.accounts;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
@Component
public class JdbcAccountsDao implements AccountsDao {

	private JdbcTemplate jdbcTemplate;
	
	public JdbcAccountsDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	//must get, update, and add to balance
	@Override
	public Accounts getAccount(String user) {
		Accounts userAccount = null;
		String sql = "SELECT accounts.account_id, accounts.user_id, accounts.balance FROM accounts\n" + 
				"join users on users.user_id = accounts.user_id\n" + 
				"where users.username = ?";
		SqlRowSet row = jdbcTemplate.queryForRowSet(sql,user);
		row.next();
		return userAccount = mapRowToAccounts(row);
	}

	private Accounts mapRowToAccounts(SqlRowSet row) {
		Accounts balance = new Accounts();
		balance.setAccount_id(row.getLong("account_id"));
		balance.setUser_id(row.getLong("user_id"));
		balance.setBalance(row.getBigDecimal("balance"));
		return balance;
	}
	
	public List<Accounts> list(){
		List<Accounts> balances = new ArrayList<Accounts>();
		String sql = "SELECT account_id, user_id, balance FROM accounts";
		SqlRowSet row = jdbcTemplate.queryForRowSet(sql);
		while(row.next()) {
			Accounts balance = mapRowToAccounts(row);
			balances.add(balance);
		}
		return balances;
	}
	
	// send money should be pending until after it has been confirmed
	// should take the current user's balance (maybe this should be in transfers...)
	
//	public void send(BigDecimal sendAmount, int otherUserId, String username) {
//		// get current user's balance
//		BigDecimal currentBalance = getAccount(username).getBalance();
//		// subtract current user's 
//		currentBalance = currentBalance.subtract(sendAmount);
//		String sql = "update accounts set balance = ? from users where username = ? and accounts.user_id = users.user_id";
//		SqlRowSet row = jdbcTemplate.queryForRowSet(sql,currentBalance,username);
//		row.next();
//		mapRowToAccounts(row);
//	}
	
	public HttpEntity<Accounts> makeEntity(Accounts accounts) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Accounts> entity = new HttpEntity<>(accounts , headers);
		return entity;
	}

}
