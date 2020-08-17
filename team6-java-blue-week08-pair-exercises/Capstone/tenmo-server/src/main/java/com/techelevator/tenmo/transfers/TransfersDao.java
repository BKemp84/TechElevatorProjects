package com.techelevator.tenmo.transfers;

import java.math.BigDecimal;
import java.util.List;

public interface TransfersDao {
	List<Transfers> listXfer(String user);
	Transfers request(String user, int amount, int accountSelection,int reqSendSelection);
	void confDeny(int statusSelection, int idSelection);
	List<Transfers> viewPendingXfers(String user);
	void additionSubtraction (String userName, BigDecimal amount, boolean isAddition, BigDecimal currentBalance);
}
