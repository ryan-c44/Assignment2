package assignment2;

import java.util.ArrayList;

public class UserManagement {

	private ArrayList<User> users = new ArrayList<User>();
	
	public UserManagement() {
		
	}

	public boolean addUser(User user) {
		return users.add(user);
	}
	
	public boolean verifyLogIn(String username, String password) {
		for(User user : users) {
			if(user.verifyLogIn(users, username, password)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean changePassword(String username, String oldPassword, String newPassword) {
		for(User user : users) {
			if(user.verifyLogIn(users, username, oldPassword)) {
				user.setPassword(newPassword);
			}
			return true;
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
	
}
