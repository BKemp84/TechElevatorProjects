package com.techelevator;

public class SavingsAccount extends BankAccount{
	
	public SavingsAccount(String accountHolder, String accountNumber, int balance) {
        super(accountHolder, accountNumber, balance);
    }

    public SavingsAccount(String accountHolder, String accountNumber) {
        super(accountHolder, accountNumber);
    }
	
	// if current balance is less than $150  an additional $2 charge
	// if withdraw is more than current balance, fails and balance stays same
  @Override
    public int withdraw(int amountToWithdraw) {
        if (getBalance() - amountToWithdraw >= 2) {
            super.withdraw(amountToWithdraw);
            if (getBalance() < 150) {
                super.withdraw(2);
            }
        }
        return getBalance();
    }

}
