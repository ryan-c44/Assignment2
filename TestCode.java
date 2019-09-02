package assignment2;

import java.util.*;

public class TestCode {
	
	public static void main(String[] args) {
		
		String username, password, newPassword;
		Scanner input = new Scanner(System.in);
	
		Address address = new Address();
		
		Customer customer = new Customer("100944", "Bob", "Jim", "bj214", "bobbyjim", true, address, "bobjim33@gmail.com");
		Billing customer1 = new Customer("109585", "Ryan", "Castles", "rc741", "castles", true, address, "bobjim33@gmail.com");
		Guest guest = new Guest("200556", "Bob", "Jim", "bj214", "bob", true);
		Staff staff = new Staff("300054", "Staff", "Member", "staff001", "staff22", true, "Head of Office");
		
		UserManagement userManagement = new UserManagement();
		userManagement.addUser(customer);
		userManagement.addUser(customer1);
		userManagement.addUser(guest);
		userManagement.addUser(staff);
		
		System.out.print("Username:");
		username = input.next();
		System.out.print("Password:");
		password = input.next();
		
		System.out.println();
		
		while(!(userManagement.verifyLogIn(username, password))) {
			System.out.print("Re-enter valid username: ");
			username= input.next();
			System.out.print("Re-enter valid password: ");
			password=input.next();
			System.out.println();
		}
		
		if(userManagement.verifyLogIn(username, password)) {
			System.out.println("Menu 1: Display User Full Name");
			System.out.println(userManagement.getUserFullNameByUserName(username));
			System.out.println();
		}
	
		System.out.println("Menu 2: Change Password");
		System.out.print("Enter current password: ");
		password=input.next();
		System.out.print("Enter new password: ");
		newPassword=input.next();
		
		if(userManagement.verifyLogIn(password, newPassword)) {
			userManagement.changePassword(username, password, newPassword);
		} 
		
		userManagement.changePassword(username, password, newPassword);
		
		System.out.println("Menu 3: List all Customer Emails");
		System.out.println(); /* Display customer email's */
		System.out.println(customer1.getEmail());
		

	
	}
}
