package assignment2;

public class Guest extends Billing {

	public Guest(String id, String firstName, String lastName, String username, String password, UserType userType,
			PermissionType permission, boolean status, Address billingAddress, String email) {
		super(id, firstName, lastName, username, password, userType, permission, status, billingAddress, email);
		
	}

	public Guest(String id, String firstName, String lastName, String username, String password, boolean status, String email) {
		this(id, firstName, lastName, username, password, UserType.Guest, PermissionType.View, status, new Address(), email);
	}
	
	public Guest(String id, String firstName, String lastName, String username, String password, boolean status) {
		this(id, firstName, lastName, username, password, UserType.Guest, PermissionType.View, status, new Address(), "default@default.com");
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
	
	public static ArrayList<Guest> filterOnlyGuestList(ArrayList<User> users) {
		
	}
	
}
