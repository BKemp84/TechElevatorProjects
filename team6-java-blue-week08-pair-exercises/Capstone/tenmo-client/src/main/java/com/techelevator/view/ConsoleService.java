package com.techelevator.view;


import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.techelevator.tenmo.models.Transfers;
import com.techelevator.tenmo.models.Users;

public class ConsoleService {

	private PrintWriter out;
	private Scanner in;

	public ConsoleService(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output, true);
		this.in = new Scanner(input);
	}

	public Object getChoiceFromOptions(Object[] options) {
		Object choice = null;
		while (choice == null) {
			displayMenuOptions(options);
			choice = getChoiceFromUserInput(options);
		}
		out.println();
		return choice;
	}

	private Object getChoiceFromUserInput(Object[] options) {
		Object choice = null;
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.valueOf(userInput);
			if (selectedOption > 0 && selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			}
		} catch (NumberFormatException e) {
			// eat the exception, an error message will be displayed below since choice will be null
		}
		if (choice == null) {
			out.println("\n*** " + userInput + " is not a valid option ***\n");
		}
		return choice;
	}

	private void displayMenuOptions(Object[] options) {
		out.println();
		for (int i = 0; i < options.length; i++) {
			int optionNum = i + 1;
			out.println(optionNum + ") " + options[i]);
		}
		out.print("\nPlease choose an option >>> ");
		out.flush();
	}

	public String getUserInput(String prompt) {
		out.print(prompt+": ");
		out.flush();
		return in.nextLine();
	}

	public Integer getUserInputInteger(String prompt) {
		Integer result = null;
		do {
			out.print(prompt+": ");
			out.flush();
			String userInput = in.nextLine();
			try {
				result = Integer.parseInt(userInput);
			} catch(NumberFormatException e) {
				out.println("\n*** " + userInput + " is not valid ***\n");
			}
		} while(result == null);
		return result;
	}
	
	public void printNum (BigDecimal num) {
		out.printf("Current Balance : $%.2f\n",num);
		out.flush();
	}
	
	public void printUserList(List<Users> users) {
		out.println("-------------------------------------------");
		out.println("Users");
		out.println("ID\t\tName");
				out.println("-------------------------------------------");
		for(Users u : users) {
			out.printf("%d)\t\t%s\n",u.getId(), u.getUsername());
		}
		out.println("-------------------------------------------");
		out.println();
	}
	
	public void printTransferList(List<Transfers> transfers, List<Users> users) {
		HashMap<Integer, String> fromNames = new HashMap<Integer, String>();
		for(Users u : users) {
			fromNames.put(u.getId(),u.getUsername());
		}

		out.println("-------------------------------------------");
		out.println("Transfers");
		out.println("ID\t\tFrom/to\t\tAmount");
		out.println("-------------------------------------------");
		for(Transfers t : transfers) {
			String fromToString = "";
			if(t.getTransfer_type_id() == 1) {
				fromToString = "To: " + fromNames.get((int)t.getAccount_to());
			}else if(t.getTransfer_type_id() == 2) {
				fromToString = "From: " + fromNames.get((int)t.getAcount_from());
			}
			out.printf("%d\t\t%s\t\t$%.2f\n",t.getTransfer_id(),fromToString,t.getAmount());
		}
		out.println("-------------------------------------------");
		out.println("");
	}
	
	public void printTransferDetails(List<Transfers> xfers, List<Users> users, int selection) {
		HashMap<Integer, String> fromNames = new HashMap<Integer, String>();
		for(Users u : users) {
			fromNames.put(u.getId(),u.getUsername());
		}
		
		HashMap<Integer,String> sendOrReceive = new HashMap<Integer,String>();
		sendOrReceive.put(1,"Request");
		sendOrReceive.put(2,"Send");
		
		HashMap<Integer,String> appStatus = new HashMap<Integer, String>();
		appStatus.put(1,"Pending");
		appStatus.put(2,"Approved");
		appStatus.put(3,"Rejected");
		
		long id = 0;
		String userTo = "";
		String userFrom = "";
		String type = "";
		String status = "";
		BigDecimal amount = null;

		out.println("--------------------------------------------");
		out.println("Transfer Details");
		out.println("--------------------------------------------");
		for(Transfers t : xfers) {
			if(selection == t.getTransfer_id()) {
				id = t.getTransfer_id();
				userTo = fromNames.get((int)t.getAccount_to());
				userFrom = fromNames.get((int)t.getAcount_from());
				type = sendOrReceive.get((int)t.getTransfer_type_id());
				status = appStatus.get((int)t.getTransfer_status_id());
				amount = t.getAmount();
				break;
			}
		}
		out.println(" Id: " + id);
		out.println(" From: " + userFrom);
		out.println(" To: " + userTo);
		out.println(" Type: " + type);
		out.println(" Status: " + status);
		out.println(" Amount: $" + amount);
	}
	
	public void printApproveRejectMenu() {
		out.println("1: Approve");
		out.println("2: Reject");
		out.println("0: Don't approve or reject");
		out.println("-------------------------------------------");
		
	}
	
	public void error() {
		out.println("An error has occured, please verify input or try again later");
	}
	
	
}
