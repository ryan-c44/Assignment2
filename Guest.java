package assignment2;

import java.util.ArrayList;

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
	protected void setId(String id) throws Exception {
		super.setId(id);
		
		if(!id.startsWith("2") || id.length() != 7 || !id.startsWith("2") && id.length() != 7 ) {
			throw new Exception();
	    }
	}
	
	@Override
	public void setPermission(PermissionType permission) throws Exception {
		
		if(!(permission.equals(PermissionType.View)) || !(permission.equals(PermissionType.None)) || !(permission.equals(PermissionType.View)) && !(permission.equals(PermissionType.None))) {
			throw new Exception();
		} else {
			super.setPermission(permission);
		}
	}
	
	public static ArrayList<Guest> filterOnlyGuestList(ArrayList<User> users) {
		
		ArrayList<Guest> guests = new ArrayList<Guest>();
		
		for(User user : users) {
			if(user.getUserType() == UserType.Guest) {
				guests.add((Guest) user);
			}
			return guests;
		}
		return null;
	}
	
}
