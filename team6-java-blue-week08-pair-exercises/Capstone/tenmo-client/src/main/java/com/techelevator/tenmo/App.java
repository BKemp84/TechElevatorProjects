package com.techelevator.tenmo;

import java.awt.List;
import java.math.BigDecimal;

import com.techelevator.tenmo.models.Accounts;
import com.techelevator.tenmo.models.AuthenticatedUser;
import com.techelevator.tenmo.models.Transfers;
import com.techelevator.tenmo.models.User;
import com.techelevator.tenmo.models.UserCredentials;
import com.techelevator.tenmo.models.Users;
import com.techelevator.tenmo.services.AccountsService;
import com.techelevator.tenmo.services.AuthenticationService;
import com.techelevator.tenmo.services.AuthenticationServiceException;
import com.techelevator.tenmo.services.TransfersService;
import com.techelevator.tenmo.services.UsersService;
import com.techelevator.view.ConsoleService;

public class App {

	private static final String API_BASE_URL = "http://localhost:8080/";

	private static final String MENU_OPTION_EXIT = "Exit";
	private static final String LOGIN_MENU_OPTION_REGISTER = "Register";
	private static final String LOGIN_MENU_OPTION_LOGIN = "Login";
	private static final String[] LOGIN_MENU_OPTIONS = { LOGIN_MENU_OPTION_REGISTER, LOGIN_MENU_OPTION_LOGIN,
			MENU_OPTION_EXIT };
	private static final String MAIN_MENU_OPTION_VIEW_BALANCE = "View your current balance";
	private static final String MAIN_MENU_OPTION_SEND_BUCKS = "Send TE bucks";
	private static final String MAIN_MENU_OPTION_VIEW_PAST_TRANSFERS = "View your past transfers";
	private static final String MAIN_MENU_OPTION_REQUEST_BUCKS = "Request TE bucks";
	private static final String MAIN_MENU_OPTION_VIEW_PENDING_REQUESTS = "View your pending requests";
	private static final String MAIN_MENU_OPTION_LOGIN = "Login as different user";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_VIEW_BALANCE, MAIN_MENU_OPTION_SEND_BUCKS,
			MAIN_MENU_OPTION_VIEW_PAST_TRANSFERS, MAIN_MENU_OPTION_REQUEST_BUCKS,
			MAIN_MENU_OPTION_VIEW_PENDING_REQUESTS, MAIN_MENU_OPTION_LOGIN, MENU_OPTION_EXIT };
	private static final String VIEW_OTHER_USERS_OPTION_SENDTEBUCKS = "View users to send TE bucks to";
	private static final String[] SEND_TE_BUCKS_OPTIONS = { VIEW_OTHER_USERS_OPTION_SENDTEBUCKS, MENU_OPTION_EXIT };
	private static final String SEND_TE_USER_PROMPT = "Enter ID of user you are sending to (0 to cancel)";
	private static final String TE_AMOUNT = "Enter amount";
	private static final String[] SEND_TE_USER_AMOUNT_PROMPTS = { SEND_TE_USER_PROMPT, TE_AMOUNT };
	private static final String VIEW_XFER_DETAILS_PROMPT = "Please enter transfer ID to view details (0 to cancel)";
	private static final String REQUEST_TE_USER_PROMPT = "Enter ID of user you are requesting from (0 to cancel)";
	private static final String VIEW_OTHER_USERS_OPTION_REQUESTTEBUCKS = "View users to request TE bucks from";
	private static final String[] REQUEST_TE_OPTIONS = { VIEW_OTHER_USERS_OPTION_REQUESTTEBUCKS, MENU_OPTION_EXIT };
	private static final String VIEW_PENDING_XFER_DETAILS_PROMPT = "Please enter transfer ID to approve/reject (0 to cancel)";
	private static final String CHOOSE_AN_OPTION_PROMPT = "Please choose an option";
	private AuthenticatedUser currentUser; // has token in it
	private ConsoleService console;
	private AuthenticationService authenticationService;
	private AccountsService accountsService;
	private UsersService usersService;
	private TransfersService transfersService;
	private int choicePastXfers = 9999;
	private int userChoiceSend = 9999;
	private int amount = 0;
	private int userChoiceRequest = 9999;
	private int choicePendingXfers = 9999;
	private int confDenySelection = 9999;
	private Transfers requestXfer = null;

	public static void main(String[] args) {
		App app = new App(new ConsoleService(System.in, System.out), new AuthenticationService(API_BASE_URL));
		app.run();
	}

	public App(ConsoleService console, AuthenticationService authenticationService) {
		this.console = console;
		this.authenticationService = authenticationService;
	}

	public void run() {
		System.out.println("*********************");
		System.out.println("* Welcome to TEnmo! *");
		System.out.println("*********************");

		registerAndLogin();
		// when currentUser is available

		accountsService = new AccountsService(API_BASE_URL, currentUser.getToken());
		usersService = new UsersService(API_BASE_URL, currentUser.getToken());
		transfersService = new TransfersService(API_BASE_URL, currentUser.getToken());

		mainMenu();
	}

	private void mainMenu() {
		while (true) {
			String choice = (String) console.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			if (MAIN_MENU_OPTION_VIEW_BALANCE.equals(choice)) {
				viewCurrentBalance();

			} else if (MAIN_MENU_OPTION_VIEW_PAST_TRANSFERS.equals(choice)) {
				viewTransferHistory(); // option 3
				choicePastXfers = console.getUserInputInteger(VIEW_XFER_DETAILS_PROMPT);
				if (choicePastXfers != 0) {
					viewTransferDetails();
				} else if (choicePastXfers == 0) {
					continue;
				}

			} else if (MAIN_MENU_OPTION_VIEW_PENDING_REQUESTS.equals(choice)) {
				viewPendingRequests();
				choicePendingXfers = console.getUserInputInteger(VIEW_PENDING_XFER_DETAILS_PROMPT);
				if (choicePendingXfers != 0) {
					console.printApproveRejectMenu();
					confDenySelection = console.getUserInputInteger(CHOOSE_AN_OPTION_PROMPT);
					approveDeny();

				} else if (choicePendingXfers == 0) {
					continue;
				}

			} else if (MAIN_MENU_OPTION_SEND_BUCKS.equals(choice)) {
				String choiceSend = (String) console.getChoiceFromOptions(SEND_TE_BUCKS_OPTIONS);
				if (VIEW_OTHER_USERS_OPTION_SENDTEBUCKS.equals(choiceSend)) {
					listAllUsers();
					userChoiceSend = console.getUserInputInteger(SEND_TE_USER_PROMPT);
					if (userChoiceSend != 0) {
						amount = console.getUserInputInteger(TE_AMOUNT);
						sendBucks();

					} else if (userChoiceSend == 0) {
						continue;
					}

				} else if (MENU_OPTION_EXIT.equals(choiceSend)) {
					continue;
				}

			} else if (MAIN_MENU_OPTION_REQUEST_BUCKS.equals(choice)) {
				String choiceRequest = (String) console.getChoiceFromOptions(REQUEST_TE_OPTIONS);
				if (VIEW_OTHER_USERS_OPTION_REQUESTTEBUCKS.equals(choiceRequest)) {
					listAllUsers();
					userChoiceRequest = console.getUserInputInteger(REQUEST_TE_USER_PROMPT);
					if (userChoiceRequest != 0) {
						amount = console.getUserInputInteger(TE_AMOUNT);
						requestBucks();
					} else if (userChoiceRequest == 0) {
						continue;
					}
				} else if (MENU_OPTION_EXIT.equals(choiceRequest)) {
					continue;
				}

			} else if (MAIN_MENU_OPTION_LOGIN.equals(choice)) {

				login();
			} else {
				// the only other option on the main menu is to exit
				exitProgram();
			}
		}
	}

	private void listAllUsers() {
		console.printUserList(usersService.listUsers());
	}

	private void approveDeny() {
		boolean approve = transfersService.confDeny(confDenySelection, choicePendingXfers, transfersService.listXfers(false),
				accountsService.listAllAccounts());
		if(approve == true) {
		Accounts account = accountsService.getAccount();
		BigDecimal num = account.getBalance();
//		 transfersService.additionSubtraction(usersService.listUsers(), true, num, choicePendingXfers, amount, requestXfer);
//		 transfersService.additionSubtraction(usersService.listUsers(), false, num, choicePendingXfers, amount, requestXfer);
		}
	}

	private void viewCurrentBalance() {
		Accounts account = accountsService.getAccount();
		BigDecimal num = account.getBalance();
		console.printNum(num);
	}

	private void viewTransferHistory() {
		console.printTransferList(transfersService.listXfers(true), usersService.listUsers());

	}

	private void viewTransferDetails() {
		console.printTransferDetails(transfersService.listXfers(true), usersService.listUsers(), choicePastXfers);
	}

	private void viewPendingRequests() {
		console.printTransferList(transfersService.listXfers(false), usersService.listUsers());
	}

	private Transfers sendBucks() {
		Accounts account = accountsService.getAccount();
		BigDecimal num = account.getBalance();
		if (num.compareTo(BigDecimal.valueOf(amount)) != -1) {
			Transfers sendXfer = transfersService.request(amount, userChoiceSend, 2);
			transfersService.additionSubtraction(usersService.listUsers(), true, num, userChoiceSend, amount, sendXfer,null);
			transfersService.additionSubtraction(usersService.listUsers(), false, num, userChoiceSend, amount, sendXfer,null);
			return sendXfer;
		}else {
			console.error();
			return null;
		}
	}

	private Transfers requestBucks() {
		return requestXfer = transfersService.request(amount, userChoiceRequest, 1);
	}

	private void exitProgram() {
		System.exit(0);
	}

	private void registerAndLogin() {
		while (!isAuthenticated()) {
			String choice = (String) console.getChoiceFromOptions(LOGIN_MENU_OPTIONS);
			if (LOGIN_MENU_OPTION_LOGIN.equals(choice)) {
				login();
			} else if (LOGIN_MENU_OPTION_REGISTER.equals(choice)) {
				register();
			} else {
				// the only other option on the login menu is to exit
				exitProgram();
			}
		}
	}

	private boolean isAuthenticated() {
		return currentUser != null;
	}

	private void register() {
		System.out.println("Please register a new user account");
		boolean isRegistered = false;
		while (!isRegistered) // will keep looping until user is registered
		{
			UserCredentials credentials = collectUserCredentials();
			try {
				authenticationService.register(credentials);
				isRegistered = true;
				System.out.println("Registration successful. You can now login.");
			} catch (AuthenticationServiceException e) {
				System.out.println("REGISTRATION ERROR: " + e.getMessage());
				System.out.println("Please attempt to register again.");
			}
		}
	}

	private void login() {
		System.out.println("Please log in");
		currentUser = null;
		while (currentUser == null) // will keep looping until user is logged in
		{
			UserCredentials credentials = collectUserCredentials();
			try {
				currentUser = authenticationService.login(credentials);
			} catch (AuthenticationServiceException e) {
				System.out.println("LOGIN ERROR: " + e.getMessage());
				System.out.println("Please attempt to login again.");
			}
		}
	}

	private UserCredentials collectUserCredentials() {
		String username = console.getUserInput("Username");
		String password = console.getUserInput("Password");
		return new UserCredentials(username, password);
	}
}