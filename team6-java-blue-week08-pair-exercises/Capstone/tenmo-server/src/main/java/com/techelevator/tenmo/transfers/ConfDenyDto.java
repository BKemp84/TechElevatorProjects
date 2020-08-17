package com.techelevator.tenmo.transfers;

public class ConfDenyDto {
	private int statusSelection; 
	private int idSelection;
	
	public ConfDenyDto() {
		
	}

	public int getStatusSelection() {
		return statusSelection;
	}

	public void setStatusSelection(int statusSelection) {
		this.statusSelection = statusSelection;
	}

	public int getIdSelection() {
		return idSelection;
	}

	public void setIdSelection(int idSelection) {
		this.idSelection = idSelection;
	}

}
