package assignment2;

import java.util.*;

public class TestCode {
	
	public static void main(String[] args) {
	
		Address address = new Address();
	
		Customer customer = new Customer("100985", "Bob", "Jim", "bj214", "bobbyjim", true, address, "bobjim33@gmail.com");
		Customer customer1 = new Customer("100985", "Ryan", "Castles", "rc741", "castles", true, address, "bobjim33@gmail.com");
		Guest guest = new Guest("200556", "Bob", "Jim", "bj214", "bobbyjim", true);
		
		UserManagement userManagement = new UserManagement();
		userManagement.addUser(customer);
		userManagement.addUser(customer1);
	
		String username, password, newPassword;
		Scanner input = new Scanner(System.in);
		System.out.print("Username:");
		username = input.next();
		System.out.print("Password:");
		password = input.next();
	
	
	
	}
}
