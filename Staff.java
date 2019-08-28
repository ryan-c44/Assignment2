package assignment2;

import java.util.*;

public class Staff extends User {
	
	private String position;

	public Staff(String id, String firstName, String lastName, String username, String password, UserType userType,
			PermissionType permission, boolean status, String position) {
		super(id, firstName, lastName, username, password, userType, permission, status);
		
		this.position = position;
		
		permission = PermissionType.Edit;
		userType = UserType.Staff;
	}
	
	protected void setId(String id) {
		super.setId(id);
		
		/* Validation */
	}
	
	public void setPermission(PermissionType permission) {
		super.setPermission(permission);
		
		/* Validation */
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
