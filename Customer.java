package assignment2;

import java.util.ArrayList;

public class Customer extends Billing {
	
	private Address customerAddress;

	public Customer(String id, String firstName, String lastName, String username, String password, UserType userType, PermissionType permission,
					boolean status, Address billingAddress, String email, Address customerAddress) {
		super(id, firstName, lastName, username, password, userType, permission, status, billingAddress, email);
		
		this.customerAddress = customerAddress;
		
		if(!id.startsWith("1") || id.length() != 6 || !id.startsWith("1") && id.length() != 6 ) {
	    	errorMessage();
	    }
	}
	
	public Customer(String id, String firstName, String lastName, String username, String password, boolean status, Address billingAddress, String email, Address customerAddress) {
		this(id, firstName, lastName, username, password, UserType.Customer, PermissionType.Booking, status, billingAddress, email, customerAddress);
	}
	
	public Customer(String id, String firstName, String lastName, String username, String password, boolean status, Address customerAddress, String email) {
		this(id, firstName, lastName, username, password, UserType.VIP, PermissionType.Booking, status, customerAddress, email, new Address());
	}
	
	@Override
	protected void setId(String id) {
		super.setId(id);
		
		if(!id.startsWith("1") || id.length() != 6 || !id.startsWith("1") && id.length() != 6 ) {
	    	errorMessage();
	    }
	}
	
	@Override
	public void setPermission(PermissionType permission) {
		super.setPermission(permission);
		
		if(!(permission == PermissionType.View) || !(permission == PermissionType.None)) {
			System.out.println("Invalid permission.");
		}
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
			if(user.getUserType() == UserType.Customer) {
				customers.add((Customer) user);
			}
		}
		return customers;
	}

	public String errorMessage() {
		return "Invalid ID.";
	}
	
	public static ArrayList<Customer> filterOnlyVIPCustomerList(ArrayList<User> users) {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		
		for(User user : users) {
			if(user.getUserType() == UserType.VIP) {
				customers.add((Customer) user);
			}
		}
		return customers;
	}
	
	

}
