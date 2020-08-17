package com.techelevator.tenmo.transfers;

import java.math.BigDecimal;


	public class Transfers{
		private long transfer_id;
		private long transfer_type_id;
		private long transfer_status_id;
		private int acount_from;
		private int account_to;
		private BigDecimal amount;
		
		public long getTransfer_id() {
			return transfer_id;
		}
		public void setTransfer_id(long transfer_id) {
			this.transfer_id = transfer_id;
		}
		
		public long getTransfer_type_id() {
			return transfer_type_id;
		}
		public void setTransfer_type_id(long transfer_type_id) {
			this.transfer_type_id = transfer_type_id;
		}
		public long getTransfer_status_id() {
			return transfer_status_id;
		}
		public void setTransfer_status_id(long transfer_status_id) {
			this.transfer_status_id = transfer_status_id;
		}
		public long getAcount_from() {
			return acount_from;
		}
		public void setAcount_from(int acount_from) {
			this.acount_from = acount_from;
		}
		public long getAccount_to() {
			return account_to;
		}
		public void setAccount_to(int account_to) {
			this.account_to = account_to;
		}
		public BigDecimal getAmount() {
			return amount;
		}
		public void setAmount(BigDecimal amount) {
			this.amount = amount;
		}
		
		
		
		
}

