package assignment2;

import java.time.LocalDate;
import java.util.*;
import java.io.Console;   
import java.util.Scanner;

public class TestCode {
	
	public static void main(String[] args) throws Exception {
		
		String username, password, newPassword;
		Scanner input = new Scanner(System.in);
	
		Address address = new Address();
		
		Customer customer = new Customer("100944", "Bob", "Jim", "bj214", "bobbyjim", UserType.VIP, true, "zobjim33@gmail.com");
		Customer customer1 = new Customer("109585", "Ryan", "Castles", "rc741", "castles", true, address,"rc@gmail.com", address);
		Customer customer2 = new Customer("109485", "Ryan", "Castles", "rc751", "castles", true, address,"rc752@gmail.com", address);
		Guest guest = new Guest("202556", "Jim", "Bob", "jb214", "jimmybob", true);
		Staff staff = new Staff("300054", "Allen", "Smith", "staff001", "staff223", true, "Head of Office");
		
		Service service1 = new Service("676478", "Train", "NSW Train Service", "", 3.00, 6.99, true);
		Service service2 = new Service("675778", "Taxi", "NSW Taxi Service", "", 2.00, 15.99, true);
		
		BookingRecord booking1 = new BookingRecord(customer, service1, LocalDate.of(2019, 7, 7), LocalDate.of(2019, 8, 8), true);
		BookingRecord booking2 = new BookingRecord(customer1, service2, LocalDate.of(2019, 7, 7), LocalDate.of(2019, 8, 8), true);
		
		UserManagement userManagement = new UserManagement();
		ServicesManagement servicesManagement = new ServicesManagement();
		BookingManagement bookingManagement = new BookingManagement();
		
		userManagement.readCsv("C:\\\\Users\\\\New\\\\Desktop\\\\file.txt"); //Only reads Guest users, couldn't figure out how to do two types of User.
		
		userManagement.addUser(customer);
		userManagement.addUser(customer1);
		userManagement.addUser(customer2);
		userManagement.addUser(staff);
		
		servicesManagement.addService(service1);
		servicesManagement.addService(service2);
		
		bookingManagement.addBookingRecord(booking1);
		bookingManagement.addBookingRecord(booking2);
		
		/*Test all methods */
		System.out.println("Customer methods: \n");
		System.out.println("Verify Permission (Customer - Booking): " + customer.verifyPermission(PermissionType.Booking));
		System.out.println("Verify User Type (Customer or VIP): " +customer.verifyUserType(UserType.VIP));
		System.out.println("Verify Username and Password: " + customer.verifyUsernameAndPassword("bj214", "bobbyjim"));
		System.out.println("Verify Username: " + customer.verifyUsername("bj214"));
		
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
		
		System.out.println("Service Methods: \n");
		System.out.println("Get Data to Save To File: " + service1.getDataToSaveToFile());
		System.out.println("Clone Service1: " + service1.clone());
		
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
		
		System.out.println("Booking Methods: \n");
		System.out.println("Get Data to Save to File (booking1): " + booking1.getDataToSaveToFile());
		
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
		
		System.out.println("User Management Methods: ");
		System.out.println("Get User Full Name by Username: " + userManagement.getUserFullNameByUserName("bj214"));
		System.out.println("Chage password: " + userManagement.changePassword("bj214", "bobbyjim", "bobbyjim1"));
		System.out.println("Verify Login with new pass: " + customer.verifyUsernameAndPassword("bj214", "bobbyjim1"));
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
		
		Console console = System.console(); 
		
		System.out.print("Username:");
		username = input.next();
		System.out.print("Password:");
		char[] pass = console.readPassword();
		password = String.valueOf(pass);
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
			System.out.println("User Type: " + userManagement.returnUserType(username));
			System.out.println();
		}
	
		System.out.println("Menu 2: Change Password");
		System.out.print("Enter current password: ");
		password=input.next();
		System.out.print("Enter new password: ");
		newPassword=input.next();
		System.out.println();
		
		if(userManagement.verifyLogIn(username, password)) {
			userManagement.changePassword(username, password, newPassword);
		} else {
			while(true) {
				System.out.print("Enter current password: ");
				password=input.next();
				System.out.print("Enter new password: ");
				newPassword=input.next();
				System.out.println();
			}
		}
		
		userManagement.changePassword(username, password, newPassword);
		
		System.out.println("Menu 3: List all Customer Emails");
		System.out.println(userManagement.getCustomerEmailsOnly());
		
		if(userManagement.checkStaff(username)) {
			System.out.println("Menu 4: Staff Only");
			System.out.println("Press 'i' to sort customers by ID.");
			System.out.print("Input: ");
			String sort = input.next();
			if(sort.equals("i")) {
				System.out.println(userManagement.sortById());
				System.out.println();
			}
			
			System.out.println("Menu 5: Filter VIP Customer Emails");
			System.out.println("press 'v' to filter VIP customer emails.");
			System.out.print("Input: ");
			String next = input.next();
			if(next.equals("v")) {
				System.out.println(userManagement.getVIPCustomerEmails());
			}
			
			System.out.println("Menu 7: Search Booking Record");
			System.out.print("Search by name: ");
			String name = input.next();
			System.out.print(bookingManagement.findBookingRecordByUsername(name));
	
		} else {
			System.out.println("Menu 6: Keyword Search for Service Name");
			System.out.print("Search for service by name: ");
			String search = input.next();
			System.out.println(servicesManagement.findServiceByKeyWordSearch(search));
		}

	
	}
}
