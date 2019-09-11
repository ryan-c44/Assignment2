package assignment2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class UserManagement {

	private ArrayList<User> users = new ArrayList<User>();
	private Map<String, User> usersMap = new HashMap<String, User>();
	
	public UserManagement() {
		
	}

	public boolean addUser(User user) {
		return users.add(user);
	}
	
	public boolean verifyLogIn(String username, String password) {
		for(User user : users) {
			if(user.verifyUsernameAndPassword(username, password)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean changePassword(String username, String oldPassword, String newPassword) throws Exception {
		for(User user : users) {
			if(user.verifyUsernameAndPassword(username, oldPassword)) {
				user.setPassword(newPassword);
			}
		}
		return true;
	}

	
	public String getUserFullNameByUserName(String username) {
		for(User user : users) {
			if(user.getUsername().equals(username)) {
				return user.getFullName();
			}
		}
		return null;
	}
	
	public User findUserByUserName(String username) {
		for(User user : users) {
			if(user.getUsername().equals(username)) {
				return user;
			}
		}
		return null;
	}
	
	public String getCustomerEmailsOnly() {
		ArrayList<Customer> customers = Customer.filterOnlyCustomerList(users);
		customers.addAll(Customer.filterOnlyVIPCustomerList(users));
		String emails = "";
		
		for(Customer customer : customers) {
			emails += customer.getFullName() + ": " + customer.getEmail() + "\n";
		}
		return emails;
	}
	
	public String getVIPCustomerEmails() {
		ArrayList<Customer> customers = Customer.filterOnlyVIPCustomerList(users);
		String emails = "";
		
		for(Customer customer : customers) {
			emails += customer.getFullName() + ": " + customer.getEmail() + "\n";
		}
		return emails;
	}
	
	public boolean checkStaff(String username) {
		for(User user : users) {
			if(findUserByUserName(username).getUserType().equals(UserType.Staff)) {
				return true;
			}
		}
		return false;
	}
	
	public UserType returnUserType(String username) {
		for(User user : users) {
			return findUserByUserName(username).getUserType();
		}
		return null;
	}

	public ArrayList<Customer> sortByEmail() {
		ArrayList<Customer> customers = Customer.filterOnlyCustomerList(users);
		customers.addAll(Customer.filterOnlyVIPCustomerList(users));
		
		for(Customer customer : customers) {
			customer.compareTo(customer);
		}
		return customers;
	}
	
	/* Step 1. Write the UserManagement class.
	2. Write the method that reads all users from a csv file (same format as mentioned in assignment 1's 'csv' format) and stores them into UserManagement's ArrayList.
	3. Make sure you call that method at some point before displaying the UI menu for the first time. */

	 
	public String csvStringCustomer(Customer customer) {
		String csv = customer.getId() + ", " + customer.getFirstName() + ", " + customer.getLastName() +
				", " + customer.getUsername() + ", " + customer.getPassword() + ", " + customer.getStatus() + ", " + customer.getBillingAddress() + ", " 
				+ customer.getEmail() + ", " + customer.getCustomerAddress();
		
		return csv;
	}
	
	public String csvStringGuest(Guest guest) {
		String csv = guest.getId() + ", " + guest.getFirstName() + ", " + guest.getLastName() +
				", " + guest.getUsername() + ", " + guest.getPassword() + ", " + guest.getStatus();
		
		return csv;
	}
	
	public Customer parseCsvCustomer(String csvString) {
		/* String id, String firstName, String lastName, String username, String password, boolean status, Address billingAddress, String email, Address customerAddress */
		String[] parts = csvString.split(", "); 
		
		String id = parts[0];
		String firstName = parts[1];
		String lastName = parts[2];
		String username = parts[3];
		String password = parts[4];
		boolean status = Boolean.parseBoolean(parts[6]);
		Address billingAddress = parseAddress(parts[7]);
		String email = parts[8];
		Address customerAddress = parseAddress(parts[9]);
		
		Customer customer = new Customer(id, firstName, lastName, username, password, status, billingAddress, email, customerAddress);
		return customer;
		
	} 
	
	public Guest parseCsvGuest(String csvString) {
		
		String[] parts = csvString.split(", ");
		String id = parts[0];
		String firstName = parts[1];
		String lastName = parts[2];
		String username = parts[3];
		String password = parts[4];
		boolean status = Boolean.parseBoolean(parts[5]);
		
		Guest guest = new Guest(id, firstName, lastName, username, password, status);
		return guest;
		
	}
	
	public void readCsv(String filename) {
		try {
			File file = new File(filename);
			
			if(file.exists()) {
				FileReader fr = new FileReader(filename);
				BufferedReader reader = new BufferedReader(fr);
				
				while(true) {
					String csvString = reader.readLine();
					if(csvString == null) {
						reader.close();
						break;
					}
					//Guest guest = parseCsvGuest(csvString);
					Customer customer = parseCsvCustomer(csvString);
					//users.add(guest);
					users.add(customer);
					
				}
			}
		}catch(IOException exception) {
				exception.printStackTrace();
		}
	}
	
	public Address parseAddress(String s) {
		String [] parts = s.split(", ");
		
		String street_name = parts[0];
		String street_number = parts[1];
		String suburb = parts[2];
		String city = parts[3];
		String state = parts[4];
		int postcode = Integer.parseInt(parts[5]);
		
		Address address = new Address(street_name, street_number, suburb, city, state, postcode);
		return address;
	}
	
}
