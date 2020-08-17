package com.techelevator;

public class CheckingAccount extends BankAccount{
	
	public CheckingAccount(String accountHolder, String accountNumber, int balance) {
        super(accountHolder, accountNumber, balance);
    }

    public CheckingAccount(String accountHolder, String accountNumber) {
        super(accountHolder, accountNumber);
    }
	
	 @Override
	
         public int withdraw(int amountToWithdraw) {
	        
	        if (getBalance() - amountToWithdraw > -100) {
	            super.withdraw(amountToWithdraw);
	            
	            if (getBalance() < 0) {
	                super.withdraw(10);
	            }
	        }
	        return getBalance();
	    }
			

}
