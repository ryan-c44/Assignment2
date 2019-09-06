package assignment2;

import java.util.*;

public abstract class Billing extends User {
	
	private Address billingAddress;
	private String email;
	
	public Billing(String id, String firstName, String lastName, String username, String password, UserType userType,
			PermissionType permission, boolean status, Address billingAddress, String email) {
		super(id, firstName, lastName, username, password, userType, permission, status);
		
		this.billingAddress = billingAddress;
		this.email = email;
	}

	public Billing(String id, String firstName, String lastName, String username, String password, UserType userType,
			PermissionType permission, boolean status, String email) {
		this(id, firstName, lastName, username, password, userType, permission, status, new Address(), email);
	}
	
	public Billing(String id, String firstName, String lastName, String username, String password, UserType userType,
			PermissionType permission, boolean status) {
		this(id, firstName, lastName, username, password, userType, permission, status, new Address(), "default@default.com");
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws Exception {
		for(int i = 0; i < email.length(); i++) {
			if(email.indexOf("@") >= 1) {
				if(email.indexOf(".") >= email.indexOf("@") + 2)
					this.email = email;
			} else {
				throw new Exception();
			}
		}
	}
	
	@Override
	public String toString() {
		return (super.toString() + ", Billing Address= " + billingAddress + ", Email= " + email) + "\n";
	}
	
	public static void sortedListByEmail(ArrayList<Billing> list) {
		Collections.sort(list, new SortByEmail());
	}
	
	public static ArrayList<Billing> filterOnlyBillingList(ArrayList<User> users) {
		
		ArrayList<Billing> billingList = new ArrayList<Billing>();
		
		for(User user : users) {
			if(user.getUserType().equals(UserType.Guest) || user.getUserType().equals(UserType.Customer)) {
				billingList.add((Billing) user);
			}
		}
		return billingList;
	}
	
}
