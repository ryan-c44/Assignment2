package assignment2;

import java.util.ArrayList;

public class Customer extends User {
	
	private Address customerAddress;

	public Customer(String id, String firstName, String lastName, String username, String password, UserType userType,
			PermissionType permission, boolean status, Address customerAddress) {
		super(id, firstName, lastName, username, password, userType, permission, status);
		
		this.customerAddress = customerAddress;
		
		if(!id.startsWith("1") || id.length() != 6 || !id.startsWith("1") && id.length() != 6 ) {
	    	errorMessage();
	    }
		
		permission = PermissionType.Booking;
		userType = UserType.Customer;
	}
	
	public Customer(String id, String firstName, String lastName, String username, String password, boolean status, Address address) {
		this(id, firstName, lastName, username, password, UserType.Customer, PermissionType.Booking, status, address);
	}
	
	@Override
	protected void setId(String id) {
		super.setId(id);
		
		/* validation */
	}
	
	@Override
	public void setPermission(PermissionType permission) {
		super.setPermission(permission);
		
		/* validation */
	}
	
	public Address getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(Address customerAddress) {
		this.customerAddress = customerAddress;
	}
	
	public static ArrayList<Customer> filterOnlyCustomerList(ArrayList<User> users) {
		
		ArrayList<Customer> customers = new ArrayList<Customer>();
		
		for(User user : users) {
			if(user.getPermission().name() == "Customer") {
				customers.add((Customer) user);
			}
		}
		return customers;
	}

	public String errorMessage() {
		return "Invalid ID.";
	}
	
	public static ArrayList<Customer> filterOnlyVIPCustomerList(ArrayList<User> users) {
		
	}
	
	

}
