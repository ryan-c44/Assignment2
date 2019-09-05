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
	//private Map<String, User> usersMap = new HashMap<String, User>();
	
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
				return true;
			}
		}
		return false;
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
			if(user.getUsername().contains(username)) {
				return user;
			}
		}
		return null;
	}
	
	

	
	
	/* Step 1. Write the UserManagement class.
	2. Write the method that reads all users from a csv file (same format as mentioned in assignment 1's 'csv' format) and stores them into UserManagement's ArrayList.
	3. Make sure you call that method at some point before displaying the UI menu for the first time. */

	 
	public String csvString(Customer customer) {
		String csv = customer.getId() + ", " + customer.getFirstName() + ", " + customer.getLastName() +
				", " + customer.getUsername() + ", " + customer.getPassword() + ", " + customer.getStatus() + ", " + customer.getEmail();
		
		return csv;
	}
	
	public void writeCsv(String filename) {
		try {
			FileWriter fw = new FileWriter(filename);
			BufferedWriter writer = new BufferedWriter(fw);
			
			for(User user : users) {
				writer.write(csvString((Customer) user));
				writer.newLine();
			}
			
			writer.close();
		}catch (IOException exception) {
			exception.printStackTrace();
		}
	}
	
	public Customer parseCsv(String csvString) {
		
		String[] parts = csvString.split(", ");
		String id = parts[0];
		String firstName = parts[1];
		String lastName = parts[2];
		String username = parts[3];
		String password = parts[4];
		boolean status = Boolean.parseBoolean(parts[5]);
		String email = parts[6];
		
		Customer customer = new Customer(id, firstName, lastName, username, password, status, email);
		return customer;
		
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
					Customer customer = parseCsv(csvString);
					users.add(customer);
					
				}
			}
		}catch(IOException exception) {
				exception.printStackTrace();
		}
	}
	
		
	
	/* public Address getAddress(String parts) {
		String[] a = parts.split(", ");
		
		String street_number = a[0];
	    String street_name = a[1];
		String suburb = a[2];
		String city = a[3];
		String state = a[4];
		int postcode = Integer.parseInt(a[5]);
		
		Address address = new Address(street_number, street_name, suburb, city, state, postcode);
		return address;
	}
	*/
	
}
