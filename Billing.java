package assignment2;

//import java.util.ArrayList;

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

	protected Address getBillingAddress() {
		return billingAddress;
	}

	protected void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	protected String getEmail() {
		return email;
	}

	protected void setEmail(String email) {
		this.email = email;
		
		if(!(this.email.endsWith(".com"))) {
			this.email = "Invalid email address";
		}
	}
	
	@Override
	public String toString() {
		return (super.toString() + ", Billing Address= " + billingAddress + ", Email= " + email);
	}
	
/*	public static void sortedListByEmail(ArrayList<Billing> list) {
		
	}
	
	public static ArrayList<Billing> filterOnlyBillingList(ArrayList<User> users) {
		
	}
*/	
	
}
