package assignment2;

import java.util.*;

public class Staff extends User {
	
	private String position;

	public Staff(String id, String firstName, String lastName, String username, String password, UserType userType,
			PermissionType permission, boolean status, String position) {
		super(id, firstName, lastName, username, password, userType, permission, status);
		
		this.position = position;
	}
	
	public Staff(String id, String firstName, String lastName, String username, String password, boolean status, String position) {
		this(id, firstName, lastName, username, password, UserType.Staff, PermissionType.Edit, status, position);
	}
	
	@Override
	protected void setId(String id) {
		super.setId(id);
		
		if(!id.startsWith("3") || id.length() != 7 || !id.startsWith("3") && id.length() != 7 ) {
	    	errorMessage();
	    }
	}
	
	@Override
	public void setPermission(PermissionType permission) {
		super.setPermission(permission);
		
		if(!(permission.equals(PermissionType.Edit)) || !(permission.equals(PermissionType.None)) || !(permission.equals(PermissionType.Edit)) && !(permission.equals(PermissionType.None))) {
			System.out.println("Invalid permission.");
		}
	}
	
	public ArrayList<Staff> filterOnlyStaffList(ArrayList<User> users) {
		ArrayList<Staff> staff = new ArrayList<Staff>();
		for(User user : users) {
			if(user.getUserType() == UserType.Staff) {
				staff.add((Staff) user);
			}
		}
		return staff;
	}
	
	public String toString() {
		return (super.toString() + ", " + position);
	}
	
	

	
}
