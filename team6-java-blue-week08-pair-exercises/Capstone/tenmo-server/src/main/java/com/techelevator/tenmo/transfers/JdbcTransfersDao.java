package com.techelevator.tenmo.transfers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
@Component
public class JdbcTransfersDao implements TransfersDao{
	
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTransfersDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	// view transfers as a logged in user
	// view details of transfer when selected
	
	private Transfers mapRowToTransfers(SqlRowSet row) {
		Transfers transfers = new Transfers();
		transfers.setTransfer_id(row.getLong("transfer_id"));
		transfers.setTransfer_type_id(row.getLong("transfer_type_id"));
		transfers.setTransfer_status_id(row.getLong("transfer_status_id"));
		transfers.setAcount_from(row.getInt("account_from"));
		transfers.setAccount_to(row.getInt("account_to"));
		transfers.setAmount(row.getBigDecimal("amount"));
		return transfers;
	}
	
	public List<Transfers> listXfer(String user){
		List<Transfers> transfers = new ArrayList<Transfers>();
		String sql = "select transfers.transfer_id, transfers.transfer_type_id, transfers.transfer_status_id, transfers.account_from, transfers.account_to, transfers.amount from transfers\n" + 
				"join accounts on transfers.account_from = accounts.account_id\n" + 
				"join users on users.user_id = accounts.user_id\n" + 
				"where account_from = (select users.user_id from users where users.username = ?) or account_to = (select users.user_id from users where users.username = ?)";
		SqlRowSet row = jdbcTemplate.queryForRowSet(sql,user,user);
		while(row.next()) {
			Transfers transfer = mapRowToTransfers(row);
			transfers.add(transfer);
		}
		return transfers;
	}
	
	public Transfers request(String user, int amount, int accountSelection, int reqSelection) {
		String nameSql = "select user_id from users where username = ?";
		SqlRowSet nameRow = jdbcTemplate.queryForRowSet(nameSql,user);
		nameRow.next();
		int currentUserId = nameRow.getInt(1);
		int pendApp = 0;
		
		if(reqSelection == 2) {
			pendApp = 2;
		}
		else if (reqSelection == 1) {
			pendApp = 1;
		}
		
		Transfers transfer = new Transfers();
		// SELECT transfer_id (DEFAULT), transfer_type_id, transfer_status_id, account_from, account_to, amount FROM transfers;
		String sql = "insert into transfers values (default, ?,?,?,?,?) returning transfer_id";
		SqlRowSet row = jdbcTemplate.queryForRowSet(sql, reqSelection, pendApp, currentUserId, accountSelection, amount);
		row.next();
		transfer.setAccount_to(accountSelection);
		transfer.setAcount_from(currentUserId);
		transfer.setAmount(BigDecimal.valueOf(amount));
		transfer.setTransfer_id(row.getLong("transfer_id"));
		transfer.setTransfer_status_id(1);
		transfer.setTransfer_type_id(reqSelection);
		return transfer;
	}
	
	public void confDeny(int statusSelection, int idSelection) {
		int newStatus = 0;
		if(statusSelection == 1) { // approve
			newStatus = 2; // approve 
		}else if (statusSelection == 2) { // deny
			newStatus = 3; // deny
		}
		String sql = "update transfers set transfer_status_id = ? where transfer_id = ?";
		jdbcTemplate.update(sql,newStatus,idSelection);
	}
	
	public List<Transfers> viewPendingXfers(String user) {
		List<Transfers> pendingTransfers = new ArrayList<Transfers>();
		String sql = "select * from transfers\n" + 
				"join accounts on transfers.account_from = accounts.account_id\n" + 
				"join users on users.user_id = accounts.user_id\n" + 
				"where users.username = ? and transfer_status_id = 1";
		SqlRowSet row = jdbcTemplate.queryForRowSet(sql,user);
		while(row.next()) {
			Transfers pendingTransfer = mapRowToTransfers(row);
			pendingTransfers.add(pendingTransfer);
		}
		return pendingTransfers;
	}
	
	public void additionSubtraction(String userName, BigDecimal amount, boolean isAddition, BigDecimal currentBalance) {
		BigDecimal updateValue = null; 
		if(isAddition == true) {
			updateValue = currentBalance.add(amount);
		}
		else if (isAddition == false) {
			updateValue = currentBalance.subtract(amount);
		}
		String sql = "update accounts set balance = ? from users where username = ? and accounts.user_id = users.user_id";
		jdbcTemplate.update(sql, updateValue, userName);
	}

}
