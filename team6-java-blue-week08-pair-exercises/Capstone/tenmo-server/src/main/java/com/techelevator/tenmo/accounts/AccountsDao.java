package com.techelevator.tenmo.accounts;

import java.math.BigDecimal;
import java.util.List;

public interface AccountsDao {
    Accounts getAccount(String user);
	List<Accounts> list();
//	void updateBalance(BigDecimal sendAmount, int otherUserId, String currentUser);
}
